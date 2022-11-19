package screens.par_follow_org_screens;

import par_unfollow_org_use_case.ParUnfollowOrgInputBoundary;
import par_unfollow_org_use_case.ParUnfollowOrgRequestModel;
import par_unfollow_org_use_case.ParUnfollowOrgResponseModel;

import java.sql.SQLException;

public class UnfollowOrgController {

    final ParUnfollowOrgInputBoundary interactor;
    public UnfollowOrgController(ParUnfollowOrgInputBoundary interactor){
        this.interactor= interactor;
    }

    public ParUnfollowOrgResponseModel unfollow(String par_username, String org_username) throws SQLException, ClassNotFoundException {
        ParUnfollowOrgRequestModel request= new ParUnfollowOrgRequestModel(par_username,org_username);
        return interactor.unfollow(request);
    }

}
