package par_unfollow_org_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.common_controller_presenter.par_unfollow_org.ParUnfollowOrgController;
import controller_presenter_view.common_controller_presenter.par_unfollow_org.ParUnfollowOrgPresenter;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgInputBoundary;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgInteractor;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgOutputBoundary;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgResponseModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Need to create "ben" as a participant and "UofT" as an organization
 * Need "ben" and "UofT" in the follow_org_par table in database
 */
public class ParUnfollowOrgTest {
    final ParDsGateway par = new ParFileUser();
    final ParUnfollowOrgOutputBoundary presenter = new ParUnfollowOrgPresenter();
    final ParUnfollowOrgInputBoundary interactor = new ParUnfollowOrgInteractor(par,presenter);
    final ParUnfollowOrgController controller = new ParUnfollowOrgController(interactor);
    ParUnfollowOrgResponseModel responseModel;

    @Test
    @Order(1)
    void testParUnfollowOrg() {
        String parUsername = "ben";
        String orgUsername = "UofT";
        try {
            responseModel = controller.unfollow(parUsername,orgUsername);
            assertEquals("You have unfollowed UofT.", responseModel.getMessage());

            OrgDsGateway orgDsGateway = new OrgFileUser();
            ArrayList<String> followers = orgDsGateway.getFollowers(orgUsername);
            if (followers.contains(parUsername)) {assert(false);}
            else {assert(true);}
        } catch (Exception e) {
            assert(false);
        }
    }
}
