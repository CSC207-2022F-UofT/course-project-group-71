package par_follow_org_use_case;

import database.ParDsGateway;

public class FollowOrgInteractor implements FollowOrgInputBoundary {

    ParDsGateway parDsGateway;
    FollowOrgOutputBoundary followOrgPresenter;

    public FollowOrgInteractor(ParDsGateway parDsGateway, FollowOrgOutputBoundary followOrgPresenter){
        this.parDsGateway=parDsGateway;
        this.followOrgPresenter= followOrgPresenter;
    }

    public FollowOrgResponseModel follow(FollowOrgRequestModel requestModel){
        parDsGateway.followOrg(requestModel.getPar_username(),requestModel.getOrg_username());
        FollowOrgResponseModel responseModel = new FollowOrgResponseModel(requestModel.getOrg_username());
        return followOrgPresenter.prepareSuccessScreen(responseModel);
    }
}
