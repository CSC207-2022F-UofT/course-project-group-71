package par_leave_event_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.common_controller_presenter.par_leave_event.ParLeaveEventController;
import controller_presenter_view.common_controller_presenter.par_leave_event.ParLeaveEventPresenter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParLeaveEventTest {
    ParDsGateway parDsGateway = new ParFileUser();
    OrgDsGateway orgDsGateway = new OrgFileUser();
    ParLeaveEventOutputBoundary presenter = new ParLeaveEventPresenter();

    ParLeaveEventInputBoundary interactor = new ParLeaveEventInteractor(parDsGateway,orgDsGateway,presenter);

    ParLeaveEventController controller = new ParLeaveEventController(interactor);

    ParLeaveEventResponseModel responseModel = null;

    /**Need to create "P10" as a participant in parfile and an organization in orgfile
     * Need to add "E6" in the eventfile
     * Need to add "P10" and "E6" in upcoming_events_for_par
     * Need to add the organization and "E6" in upcoming_events_for_org
     */
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
