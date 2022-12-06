package par_leave_event_use_case;

import controllers.ParLeaveEventController;
import presenters.ParLeaveEventPresenter;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import use_cases.par_leave_event_use_case.ParLeaveEventInputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventInteractor;
import use_cases.par_leave_event_use_case.ParLeaveEventOutputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventResponseModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Need to create "P10" as a participant in parfile and an organization in orgfile
 * Need to add "E6" in the eventfile
 * Need to add "P10" and "E6" in upcoming_events_for_par
 * Need to add the organization and "E6" in upcoming_events_for_org
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParLeaveEventTest {
    final ParDsGateway parDsGateway = new ParFileUser();
    final ParLeaveEventOutputBoundary presenter = new ParLeaveEventPresenter();
    final ParLeaveEventInputBoundary interactor = new ParLeaveEventInteractor(parDsGateway,presenter);
    final ParLeaveEventController controller = new ParLeaveEventController(interactor);
    ParLeaveEventResponseModel responseModel;


    @Test
    @Order(1)
    void testPrepareSuccessView(){
        try {
            responseModel = controller.leave("P10","E6");
            assertEquals("You have left the event E6.", responseModel.getMessage());
            parDsGateway.registerEvent("P10", "E6");
        } catch (Exception e) {
            assert(false);
        }
    }
}
