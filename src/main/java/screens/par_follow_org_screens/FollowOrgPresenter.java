package screens.par_follow_org_screens;

import par_follow_org_use_case.FollowOrgOutputBoundary;
import par_follow_org_use_case.FollowOrgOutputBoundary;
import par_follow_org_use_case.FollowOrgResponseModel;

public class FollowOrgPresenter implements FollowOrgOutputBoundary {

    public FollowOrgResponseModel prepareSuccessPage(FollowOrgResponseModel responseModel) {

        responseModel.setMessage("You have followed " +responseModel.getOrgName() + "!");
        return responseModel;

    }
}
