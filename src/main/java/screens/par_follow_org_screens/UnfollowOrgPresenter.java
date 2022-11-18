package screens.par_follow_org_screens;

import par_unfollow_org_use_case.UnfollowOrgOutputBoundary;
import par_unfollow_org_use_case.UnfollowOrgResponseModel;

public class UnfollowOrgPresenter implements UnfollowOrgOutputBoundary {

    public UnfollowOrgResponseModel prepareSuccessPage(UnfollowOrgResponseModel responseModel) {

        responseModel.setMessage("You have unfollowed " +responseModel.getOrgName() + ".");
        return responseModel;

    }
}
