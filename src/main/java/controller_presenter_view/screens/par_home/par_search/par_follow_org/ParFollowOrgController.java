package controller_presenter_view.screens.par_home.par_search.par_follow_org;

import use_cases.par_follow_org_use_case.ParFollowOrgInputBoundary;
import use_cases.par_follow_org_use_case.ParFollowOrgRequestModel;
import use_cases.par_follow_org_use_case.ParFollowOrgResponseModel;

import java.sql.SQLException;

public class ParFollowOrgController {

    final ParFollowOrgInputBoundary interactor;
    public ParFollowOrgController(ParFollowOrgInputBoundary interactor){
        this.interactor= interactor;
    }

    public ParFollowOrgResponseModel follow(String par_username, String org_username) throws SQLException, ClassNotFoundException {
        ParFollowOrgRequestModel request= new ParFollowOrgRequestModel(par_username,org_username);
        return interactor.follow(request);
    }

}
