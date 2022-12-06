package upcomming_to_past_use_case;

import database.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controllers.UpcomingToPastController;
import presenters.UpcomingToPastPresenter;
import org.junit.jupiter.api.TestMethodOrder;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInteractor;
import use_cases.upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastResponseModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Need to create a participant "allyson" in parfile, organizations "UofT" and "UBC" in orgfile
 *  Need to create events "PHL295" and "ECO225" in eventfile, set time in past
 *  Need to link "allyson" and "ECO225" in upcoming_events_for_par
 *  Need to link "UofT" and "PHL295" in upcoming_events_for_org
 *  Need to link "UBC" and "ECO225" in upcoming_events_for_org
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
            responseModel = controller.convertToPast("O", "UofT");
            assertEquals("The following event(s) has(ve) been moved from Upcoming Event to Past Event due to the time:" +
                    "\n" + "PHL295", responseModel.getMessage());
        }catch (Exception e) {
            assert(false);
        }
    }
    @Test
    @Order(2)
    void testPrepareSuccessView_Participant() {
        try {
            responseModel = controller.convertToPast("P", "allyson");
            assertEquals("The following event(s) has(ve) been moved from Upcoming Event to Past Event due to the time:" +
                    "\n" + "ECO225", responseModel.getMessage());
        }catch (Exception e) {
            assert(false);
        }
    }


}
