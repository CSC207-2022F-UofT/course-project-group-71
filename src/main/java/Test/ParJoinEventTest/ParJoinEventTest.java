package Test.ParJoinEventTest;

import Par_Join_Event_Use_Case.ParJoinEventInputBoundary;
import Par_Join_Event_Use_Case.ParJoinEventInteractor;
import Par_Join_Event_Use_Case.ParJoinEventOutputBoundary;
import Par_Join_Event_Use_Case.ParJoinEventResponseModel;
import Par_Join_Event_screen.ParJoinEventController;
import Par_Join_Event_screen.ParJoinEventPresenter;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
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
    }}