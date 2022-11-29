package par_join_event_use_case;

import controller_presenter_view.screens.par_home.par_search.par_join_event.ParJoinEventController;
import controller_presenter_view.screens.par_home.par_search.par_join_event.ParJoinEventPresenter;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.Test;
import use_cases.par_join_event_use_case.*;
import org.junit.jupiter.api.Order;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test with participant "P2" and event "E2" in the testing database
 */
public class ParJoinEventTest {

    final ParDsGateway parDsGateway= new ParFileUser();
    final ParJoinEventOutputBoundary presenter= new ParJoinEventPresenter();
    final ParJoinEventInputBoundary interactor= new ParJoinEventInteractor(parDsGateway,presenter);
    final ParJoinEventController controller= new ParJoinEventController(interactor);
    ParJoinEventResponseModel responseModel;

    @Test
    @Order(1)
    public void testSuccessMessage(){
        try{
            responseModel= controller.join("P2","E2");
            assertEquals("Registered Successfully for eTest!", responseModel.getMessage());
        }catch (Exception e){
            assert false;
        }
    }

    @Test
    @Order(2)
    public void testUpcomingEvent() throws SQLException, ClassNotFoundException {
        ArrayList<String> al = parDsGateway.getUpcomingEvents("P2");
        boolean isUpcoming= al.contains("E2");
        assert isUpcoming;
    }







}
