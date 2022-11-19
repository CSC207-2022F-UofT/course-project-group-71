package par_leave_event_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import screens.par_upcoming_event.ParLeaveEventController;
import screens.par_upcoming_event.ParLeaveEventPresenter;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParLeaveEventTest {
    ParDsGateway parDsGateway = new ParFileUser();
    OrgDsGateway orgDsGateway = new OrgFileUser();
    ParLeaveEventOutputBoundary presenter = new ParLeaveEventPresenter();

    ParLeaveEventInputBoundary interactor = new ParLeaveEventInteractor(parDsGateway,orgDsGateway,presenter);

    ParLeaveEventController controller = new ParLeaveEventController(interactor);

    ParLeaveEventResponseModel responseModel = null;

    @Test
    @Order(1)
    void testPrepareSuccessView(){
        try {
            responseModel = controller.leave("P10","E6");
            assertEquals("Success to leave the event", responseModel.getMessage());
            parDsGateway.registerEvent("P10", "E6");
        } catch (SQLException | ClassNotFoundException e) {
            assert(false);
        }
    }
}
