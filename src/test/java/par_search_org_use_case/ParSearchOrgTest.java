package par_search_org_use_case;
import database.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.screens.par_home.par_search.ParSearchOrgController;
import controller_presenter_view.screens.par_home.par_search.ParSearchOrgPresenter;
import use_cases.par_search_org_use_case.ParSearchOrgInputBoundary;
import use_cases.par_search_org_use_case.ParSearchOrgInteractor;
import use_cases.par_search_org_use_case.ParSearchOrgResponseModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Need to create "654321" as a participant in parfile
 * Need to create organization "1", "12", "123", .... , "12345678", and "4321" in orgfile
 */
public class ParSearchOrgTest {
    OrgDsGateway orgDsGateway = new OrgFileUser();
    ParSearchOrgPresenter presenter = new ParSearchOrgPresenter();
    ParSearchOrgInputBoundary interactor = new ParSearchOrgInteractor(orgDsGateway, presenter);
    ParSearchOrgController controller = new ParSearchOrgController(interactor);
    ParSearchOrgResponseModel responseModel;

    @Test
    @Order(1)
    void test_PrepareFailureView_No_Orgs_Found(){
        try {
            responseModel = controller.orgSearch("123456789", "654321");
            assert(false);
        } catch (Exception e) {
            assertEquals("No organization found.", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void test_PrepareSuccessView_Found_Orgs(){
        try {
            responseModel = controller.orgSearch("1234", "654321");
            ArrayList<String> searchResults = new ArrayList<>();
            searchResults.add("1234");
            searchResults.add("12345");
            searchResults.add("123456");
            searchResults.add("1234567");
            searchResults.add("12345678");
            assertEquals(searchResults, responseModel.getSearchResults());
        } catch (Exception e) {
            assert(false);
        }
    }
}
