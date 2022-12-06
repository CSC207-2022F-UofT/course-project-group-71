package presenters.use_case_presenters;

import use_cases.par_unfollow_org_use_case.ParUnfollowOrgOutputBoundary;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgResponseModel;

public class ParUnfollowOrgPresenter implements ParUnfollowOrgOutputBoundary {

    public ParUnfollowOrgResponseModel prepareSuccessPage(ParUnfollowOrgResponseModel responseModel) {

        responseModel.setMessage("You have unfollowed " +responseModel.getOrgName() + ".");
        return responseModel;

    }
}
