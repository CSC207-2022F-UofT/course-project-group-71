package par_unfollow_org_use_case;

import database.ParDsGateway;

public class UnfollowOrgInteractor implements UnfollowOrgInputBoundary {

    ParDsGateway parDsGateway;
    UnfollowOrgOutputBoundary unfollowOrgOutputBoundary;

    public UnfollowOrgInteractor(ParDsGateway parDsGateway, UnfollowOrgOutputBoundary unfollowOrgOutputBoundary){
        this.parDsGateway=parDsGateway;
        this.unfollowOrgOutputBoundary= unfollowOrgOutputBoundary;
    }

    public UnfollowOrgResponseModel unfollow(UnfollowOrgRequestModel requestModel){
        parDsGateway.unfollowOrg(requestModel.getPar_username(),requestModel
                .getOrg_username());
        UnfollowOrgResponseModel responseModel = new UnfollowOrgResponseModel(requestModel.getOrg_username());
        return unfollowOrgOutputBoundary.prepareSuccessPage(responseModel);

    }
}
