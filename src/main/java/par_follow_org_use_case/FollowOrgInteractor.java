package par_follow_org_use_case;

import database.ParDsGateway;

public class FollowOrgInteractor implements FollowOrgInputBoundary {

    ParDsGateway parDsGateway;
    FollowOrgOutputBoundary followOrgPresenter;

    public FollowOrgInteractor(ParDsGateway parDsGateway, FollowOrgOutputBoundary followOrgPresenter){
        this.parDsGateway=parDsGateway;
        this.followOrgPresenter= followOrgPresenter;
    }

    public void follow(FollowOrgRequestModel requestModel){
        parDsGateway.followOrg(requestModel.getPar_username(),requestModel
                .getOrg_username());


    }
}
