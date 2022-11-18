package screens.par_follow_org_screens;

import par_follow_org_use_case.FollowOrgInputBoundary;
import par_follow_org_use_case.FollowOrgRequestModel;
import par_follow_org_use_case.FollowOrgResponseModel;
import par_unfollow_org_use_case.UnfollowOrgInputBoundary;
import par_unfollow_org_use_case.UnfollowOrgRequestModel;
import par_unfollow_org_use_case.UnfollowOrgResponseModel;

public class UnfollowOrgController {

    final UnfollowOrgInputBoundary interactor;
    public UnfollowOrgController(UnfollowOrgInputBoundary interactor){
        this.interactor= interactor;
    }

    public UnfollowOrgResponseModel unfollow(String par_username, String org_username){
        UnfollowOrgRequestModel request= new UnfollowOrgRequestModel(par_username,org_username);
        return interactor.unfollow(request);
    }

}
