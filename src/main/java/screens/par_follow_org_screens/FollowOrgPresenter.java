package screens.par_follow_org_screens;

import par_follow_org_use_case.FollowOrgOutputBoundary;
import par_follow_org_use_case.FollowOrgResponseModel;
import par_unfollow_org_use_case.UnfollowOrgResponseModel;
import screens.par_follow_org_screens.SuccessViewModel;

public class FollowOrgPresenter implements FollowOrgOutputBoundary {

    public FollowOrgResponseModel prepareSuccessScreen(FollowOrgResponseModel responseModel) {

        responseModel.setMessage("You have followed " +responseModel.getOrgName() + "!");
        return responseModel;

    }
}
