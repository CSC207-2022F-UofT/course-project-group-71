package par_follow_org_usecase;

import database.ParDsGateway;

public class FollowOrgInteractor implements FollowOrgInputBoundary {

    final ParDsGateway parDsGateway;
    final FollowOrgPresenter followOrgPresenter;

    public FollowOrgInteractor(ParDsGateway parDsGateway, FollowOrgPresenter followOrgPresenter){
        this.parDsGateway=parDsGateway;
        this.followOrgPresenter= followOrgPresenter;
    }

    public void follow(FollowOrgRequestModel requestModel){
        parDsGateway.followOrg(requestModel.getPar_username(),requestModel
                .getOrg_username());


    }
}
