package upcomming_to_past_use_case;

import database.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastController;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastPresenter;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInteractor;
import use_cases.upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastResponseModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Need to create ""
 *
 */

public class UpcomingToPastTest {
    final ParDsGateway parDsGateway = new ParFileUser();
    final EventDsGateway eventDsGateway = new EventFileUser();
    final OrgDsGateway orgDsGateway = new OrgFileUser();
    final UpcomingToPastOutputBoundary presenter = new UpcomingToPastPresenter();
    final UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway, eventDsGateway, presenter);
    final UpcomingToPastController controller = new UpcomingToPastController(interactor);
    UpcomingToPastResponseModel responseModel;

    @Test
    @Order(1)
    void testPrepareSuccessView_Organization() {
        try {
            responseModel = controller.convertToPast("P", "s");
            assertEquals("", responseModel.getMessage());
        }catch (Exception e) {
            assert(false);
        }
    }

    @Test
    @Order(2)
    void testPrepareSuccessView_Participant() {
        try {
            responseModel = controller.convertToPast("", "s");
            assertEquals("", responseModel.getMessage());
        }catch (Exception e) {
            assert(false);
        }
    }
}
