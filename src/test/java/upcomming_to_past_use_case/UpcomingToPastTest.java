package upcomming_to_past_use_case;

import database.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import screens.upcoming_to_past.UpcomingToPastController;
import screens.upcoming_to_past.UpcomingToPastPresenter;
import upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import upcoming_to_past_use_case.UpcomingToPastInteractor;
import upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import upcoming_to_past_use_case.UpcomingToPastResponseModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpcomingToPastTest {

    ParDsGateway parDsGateway = new ParFileUser();

    EventDsGateway eventDsGateway = new EventFileUser();

    OrgDsGateway orgDsGateway = new OrgFileUser();

    UpcomingToPastOutputBoundary presenter = new UpcomingToPastPresenter();

    UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway, eventDsGateway, presenter);

    UpcomingToPastController controller = new UpcomingToPastController(interactor);

    UpcomingToPastResponseModel responseModel = null;

    @Test
    @Order(1)
    void testPrepareSuccessView_Orgnization() {

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
