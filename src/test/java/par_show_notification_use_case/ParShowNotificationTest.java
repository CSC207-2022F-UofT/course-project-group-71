package par_show_notification_use_case;
import database.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.screens.par_home.par_show_notification.ParShowNotificationController;
import controller_presenter_view.screens.par_home.par_show_notification.ParShowNotificationPresenter;
import org.junit.jupiter.api.TestMethodOrder;
import use_cases.par_show_notification_use_case.ParShowNotificationInputBoundary;
import use_cases.par_show_notification_use_case.ParShowNotificationInteractor;
import use_cases.par_show_notification_use_case.ParShowNotificationResponseModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Need to create "7654321" and "654321" as participants in parfile
 * Need to assign notification "Event TeamMeeting3 is about to happen at 11-30 0:0" to "654321" in par_notification
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParShowNotificationTest {
    final ParDsGateway parDsGateway = new ParFileUser();
    final ParShowNotificationPresenter presenter = new ParShowNotificationPresenter();
    final ParShowNotificationInputBoundary interactor = new ParShowNotificationInteractor(presenter, parDsGateway);
    final ParShowNotificationController controller = new ParShowNotificationController(interactor);
    ParShowNotificationResponseModel responseModel;

    @Test
    @Order(1)
    void test_PrepareFailureView_No_Notification_Found(){
        try {
            responseModel = controller.showNotification("7654321");
            assert(false);
        } catch (Exception e) {
            assertEquals("You have no notification!", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void test_PrepareSuccessView_Found_Notifications(){
        try {
            String notifications = "Event TeamMeeting3 is about to happen at 11-30 0:0" + "\n";
            responseModel = controller.showNotification("654321");
            assertEquals(notifications, responseModel.getNotifications());
            assert(parDsGateway.getNotifications("654321").isEmpty());
        } catch (Exception e) {
            assert(false);
        }
    }
}
