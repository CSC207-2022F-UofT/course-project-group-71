package par_follow_org_usecase;

import screens.SuccessViewModel;

public class FollowOrgPresenter implements FollowOrgOutputBoundary {

    public void prepareSuccessScreen(FollowOrgResponseModel responseModel){
        SuccessViewModel svm= new SuccessViewModel(responseModel.getOrgName());
        svm.generatePage();
    }
}
