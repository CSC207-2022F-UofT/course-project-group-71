package par_join_event_use_case;

import controllers.ParJoinEventController;
import presenters.use_case_presenters.ParJoinEventPresenter;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import use_cases.par_join_event_use_case.ParJoinEventInputBoundary;
import use_cases.par_join_event_use_case.ParJoinEventInteractor;
import use_cases.par_join_event_use_case.ParJoinEventOutputBoundary;
import use_cases.par_join_event_use_case.ParJoinEventResponseModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Test with participant "P2" and event "E2" in the testing database
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
            assertEquals("Registered successfully for E2!", responseModel.getMessage());
        }catch (Exception e){
            assert false;
        }
    }

    @Test
    @Order(2)
    public void testUpcomingEvent() throws ClassNotFoundException {
        ArrayList<String> al = parDsGateway.getUpcomingEvents("P2");
        boolean isUpcoming= al.contains("E2");
        assert isUpcoming;
    }







}
