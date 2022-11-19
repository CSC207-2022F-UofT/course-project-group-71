package screens.par_follow_org_screens;

import par_follow_org_use_case.ParFollowOrgOutputBoundary;
import par_follow_org_use_case.ParFollowOrgResponseModel;

public class ParFollowOrgPresenter implements ParFollowOrgOutputBoundary {

    public ParFollowOrgResponseModel prepareSuccessPage(ParFollowOrgResponseModel responseModel) {

        responseModel.setMessage("You have followed " +responseModel.getOrgName() + "!");
        return responseModel;

    }
}
