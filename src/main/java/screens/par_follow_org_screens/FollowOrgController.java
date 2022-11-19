package screens.par_follow_org_screens;

import par_follow_org_use_case.FollowOrgInputBoundary;
import par_follow_org_use_case.FollowOrgRequestModel;
import par_follow_org_use_case.FollowOrgResponseModel;

import java.sql.SQLException;

public class FollowOrgController {

    final FollowOrgInputBoundary interactor;
    public FollowOrgController(FollowOrgInputBoundary interactor){
        this.interactor= interactor;
    }

    public FollowOrgResponseModel follow(String par_username, String org_username) throws SQLException, ClassNotFoundException {
        FollowOrgRequestModel request= new FollowOrgRequestModel(par_username,org_username);
        return interactor.follow(request);
    }

}
