package par_search_event_use_case;
import database.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.screens.par_home.par_search.ParSearchEventController;
import controller_presenter_view.screens.par_home.par_search.ParSearchEventPresenter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**Need to create "654321" as a participant in parfile, and a random organization in orgfile
 * Need to create "TeamMeeting1", "TeamMeeting2", "TeamMeeting3", "TeamMeeting4" in eventfile
 * Need to assign the above events to a random organization in upcoming_event_for_org
 */
public class ParSearchEventTest {
    EventDsGateway eventDsGateway = new EventFileUser();
    ParSearchEventPresenter presenter = new ParSearchEventPresenter();
    ParSearchEventInputBoundary interactor = new ParSearchEventInteractor(eventDsGateway, presenter);
    ParSearchEventController controller = new ParSearchEventController(interactor);
    ParSearchEventResponseModel responseModel;

    @Test
    @Order(1)
    void test_PrepareFailureView_No_Events_Found(){
        try {
            responseModel = controller.eventSearch("TeamMeeting222", "654321");
            assert(false);
        } catch (Exception e) {
            assertEquals("No event found.", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void test_PrepareSuccessView_Found_Events(){
        try {
            responseModel = controller.eventSearch("TeamMeeting", "654321");
            ArrayList<String> searchResults = new ArrayList<>();
            searchResults.add("TeamMeeting1");
            searchResults.add("TeamMeeting2");
            searchResults.add("TeamMeeting3");
            searchResults.add("TeamMeeting4");
            assertEquals(searchResults, responseModel.getSearchResults());
        } catch (Exception e) {
            assert(false);
        }
    }
}
