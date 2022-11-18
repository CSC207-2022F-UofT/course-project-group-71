package screens.par_follow_org_screens;

import par_follow_org_usecase.FollowOrgInputBoundary;
import par_follow_org_usecase.FollowOrgRequestModel;

public class FollowOrgController {

    final FollowOrgInputBoundary interactor;
    public FollowOrgController(FollowOrgInputBoundary interactor){
        this.interactor= interactor;
    }

    public void follow(String par_username, String org_username){
        FollowOrgRequestModel request= new FollowOrgRequestModel(par_username,org_username);
    }

}
