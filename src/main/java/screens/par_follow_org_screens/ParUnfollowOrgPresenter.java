package screens.par_follow_org_screens;

import par_unfollow_org_use_case.ParUnfollowOrgOutputBoundary;
import par_unfollow_org_use_case.ParUnfollowOrgResponseModel;

public class ParUnfollowOrgPresenter implements ParUnfollowOrgOutputBoundary {

    public ParUnfollowOrgResponseModel prepareSuccessPage(ParUnfollowOrgResponseModel responseModel) {

        responseModel.setMessage("You have unfollowed " +responseModel.getOrgName() + ".");
        return responseModel;

    }
}
