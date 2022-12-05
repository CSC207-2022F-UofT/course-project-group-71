package use_cases.par_follow_org_use_case;

import use_cases.par_follow_org_use_case.ParFollowOrgInputBoundary;
import use_cases.par_follow_org_use_case.ParFollowOrgRequestModel;
import use_cases.par_follow_org_use_case.ParFollowOrgResponseModel;

public class ParFollowOrgController {

    final ParFollowOrgInputBoundary interactor;
    public ParFollowOrgController(ParFollowOrgInputBoundary interactor){
        this.interactor= interactor;
    }

    public ParFollowOrgResponseModel follow(String par_username, String org_username) throws ClassNotFoundException {
        ParFollowOrgRequestModel request= new ParFollowOrgRequestModel(par_username,org_username);
        return interactor.follow(request);
    }

}
