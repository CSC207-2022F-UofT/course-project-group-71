package par_follow_org_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.screens.par_home.par_search.par_follow_org.ParFollowOrgController;
import controller_presenter_view.screens.par_home.par_search.par_follow_org.ParFollowOrgPresenter;
import use_cases.par_follow_org_use_case.ParFollowOrgInputBoundary;
import use_cases.par_follow_org_use_case.ParFollowOrgInteractor;
import use_cases.par_follow_org_use_case.ParFollowOrgOutputBoundary;
import use_cases.par_follow_org_use_case.ParFollowOrgResponseModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParFollowOrgTest {
    final ParDsGateway par = new ParFileUser();
    final ParFollowOrgOutputBoundary presenter = new ParFollowOrgPresenter();
    final ParFollowOrgInputBoundary interactor = new ParFollowOrgInteractor(par,presenter);
    final ParFollowOrgController controller = new ParFollowOrgController(interactor);
    ParFollowOrgResponseModel responseModel;

    /**Need to create "allyson" as a participant in parfile and "UBC" as an organization in orgfile
     */
    @Test
    @Order(1)
    void testParFollowOrg() {
        String parUsername = "allyson";
        String orgUsername = "UBC";
        try {
            responseModel = controller.follow(parUsername,orgUsername);
            assertEquals("You have followed UBC!", responseModel.getMessage());

            OrgDsGateway orgDsGateway = new OrgFileUser();
            ArrayList<String> followers = orgDsGateway.getFollowers(orgUsername);
            if (followers.contains(parUsername)) {assert(true);}
            else {assert(false);}
        } catch (Exception e) {
            assert(false);
        }
    }

}
