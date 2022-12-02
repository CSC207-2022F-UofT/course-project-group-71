package notify_event_use_case;

import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventController;
import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventPresenter;
import database.EventDsGateway;
import database.EventFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import use_cases.notify_event_use_case.NotifyEventInputBoundary;
import use_cases.notify_event_use_case.NotifyEventInteractor;
import use_cases.notify_event_use_case.NotifyEventOutputBoundary;
import use_cases.notify_event_use_case.NotifyEventResponseModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Need to create "TeamMeeting1", "TeamMeeting2", "TeamMeeting3", "TeamMeeting4" in eventfile
 * Need to create a participant in particle
 * Assign the participant to TeamMeeting4 in upcoming_event_for_par
 * Assign the participant to TeamMeeting3 in past_event_for_par
 ***** IMPORTANT NOTICE: I added TimeUnit.SECONDS.sleep() in testing, because notifications might not have been
 *                      stored in database by time we try to retrieve them. You can modify the time a bit longer
 *                      depending on your hardware.
 */
public class NotifyEventTest {
    final ParDsGateway parDsGateway = new ParFileUser();
    final EventDsGateway eventDsGateway = new EventFileUser();
    final NotifyEventOutputBoundary presenter = new NotifyEventPresenter();
    final NotifyEventInputBoundary interactor = new NotifyEventInteractor(eventDsGateway, parDsGateway,
            presenter);
    final NotifyEventController controller = new NotifyEventController(interactor);
    NotifyEventResponseModel responseModel;


    @Test
    @Order(1)
    void test_PrepareFailureView_No_Pars_Future(){
        try {
            responseModel = controller.sendNotification("Future", "TeamMeeting1");
            assert(false);
        } catch (Exception e) {
            assertEquals("No participant has registered up for TeamMeeting1!", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void test_PrepareFailureView_No_Pars_Past(){
        try {
            responseModel = controller.sendNotification("Past", "TeamMeeting2");
            assertEquals("Event TeamMeeting2 was over.", responseModel.getMessage());
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    @Order(3)
    void test_PrepareSuccessView_Past(){
        try {
            responseModel = controller.sendNotification("Past", "TeamMeeting3");
            assertEquals("Event TeamMeeting3 was over.", responseModel.getMessage());
            assert(parDsGateway.getNotifications("654321").contains("Event TeamMeeting3 was over at 1-1 1:1."));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    @Order(4)
    void test_PrepareSuccessView_Future(){
        try {
            responseModel = controller.sendNotification("Future", "TeamMeeting4");
            assertEquals("Notification sent for TeamMeeting4!", responseModel.getMessage());
            assert(parDsGateway.getNotifications("654321").contains("Event TeamMeeting4 is about to happen at 1-1 1:1!"));
            parDsGateway.clearNotifications("654321");
        } catch (Exception e) {
            assert(false);
        }
    }
}
