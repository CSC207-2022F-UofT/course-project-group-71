package controller_presenter_view.screens.par_home.par_search.par_follow_org;

import use_cases.par_follow_org_use_case.ParFollowOrgOutputBoundary;
import use_cases.par_follow_org_use_case.ParFollowOrgResponseModel;

public class ParFollowOrgPresenter implements ParFollowOrgOutputBoundary {

    public ParFollowOrgResponseModel prepareSuccessPage(ParFollowOrgResponseModel responseModel) {

        responseModel.setMessage("You have followed " +responseModel.getOrgName() + "!");
        return responseModel;

    }
}
