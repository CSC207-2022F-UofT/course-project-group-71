package controller_presenter_view.common_controller_presenter.par_unfollow_org;

import use_cases.par_unfollow_org_use_case.ParUnfollowOrgInputBoundary;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgRequestModel;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgResponseModel;

import java.sql.SQLException;

/**The controller will be called by:
 * 1. ParSearchOrgResultsPageActionListener   When the participant clicks the "Unfollow" button on ParSearchOrgResultsPage
 * 2. ParFollowedOrgActionListener            When the organization clicks the "Unfollow" button on ParFollowedOrgPage
 */
public class ParUnfollowOrgController {

    final ParUnfollowOrgInputBoundary interactor;

    public ParUnfollowOrgController(ParUnfollowOrgInputBoundary interactor){
        this.interactor= interactor;
    }

    public ParUnfollowOrgResponseModel unfollow(String par_username, String org_username) throws ClassNotFoundException {
        ParUnfollowOrgRequestModel request= new ParUnfollowOrgRequestModel(par_username,org_username);
        return interactor.unfollow(request);
    }

}
