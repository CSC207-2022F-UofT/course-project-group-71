package screens.par_follow_org_screens;

import par_follow_org_use_case.ParFollowOrgInputBoundary;
import par_follow_org_use_case.ParFollowOrgRequestModel;
import par_follow_org_use_case.ParFollowOrgResponseModel;

import java.sql.SQLException;

public class FollowOrgController {

    final ParFollowOrgInputBoundary interactor;
    public FollowOrgController(ParFollowOrgInputBoundary interactor){
        this.interactor= interactor;
    }

    public ParFollowOrgResponseModel follow(String par_username, String org_username) throws SQLException, ClassNotFoundException {
        ParFollowOrgRequestModel request= new ParFollowOrgRequestModel(par_username,org_username);
        return interactor.follow(request);
    }

}
