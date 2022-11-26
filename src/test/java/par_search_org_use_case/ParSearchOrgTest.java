package par_search_org_use_case;
import database.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.screens.par_home.par_search.ParSearchOrgController;
import controller_presenter_view.screens.par_home.par_search.ParSearchOrgPresenter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParSearchOrgTest {
    OrgDsGateway orgDsGateway = new OrgFileUser();

    ParSearchOrgPresenter presenter = new ParSearchOrgPresenter();
    ParSearchOrgInputBoundary interactor = new ParSearchOrgInteractor(orgDsGateway, presenter);
    ParSearchOrgController controller = new ParSearchOrgController(interactor);
    ParSearchOrgResponseModel responseModel = null;

    @Test
    @Order(1)
    void test_PrepareFailureView_No_Orgs_Found(){
        try {
            responseModel = controller.orgSearch("123456789", "654321");
            assert(false);
        } catch (Exception e) {
            assertEquals("No organizers found.", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void test_PrepareSuccessView_Found_Orgs(){
        try {
            responseModel = controller.orgSearch("1234", "654321");
            ArrayList<String> searchResults = new ArrayList<>();
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
