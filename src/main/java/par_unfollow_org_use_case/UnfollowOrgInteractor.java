package par_unfollow_org_use_case;

import database.ParDsGateway;
import par_follow_org_use_case.FollowOrgResponseModel;

import java.sql.SQLException;

public class UnfollowOrgInteractor implements UnfollowOrgInputBoundary {

    ParDsGateway parDsGateway;
    UnfollowOrgOutputBoundary unfollowOrgPresenter;

    public UnfollowOrgInteractor(ParDsGateway parDsGateway, UnfollowOrgOutputBoundary unfollowOrgPresenter){
        this.parDsGateway=parDsGateway;
        this.unfollowOrgPresenter= unfollowOrgPresenter;
    }

    public UnfollowOrgResponseModel unfollow(UnfollowOrgRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.unfollowOrg(requestModel.getPar_username(),requestModel
                .getOrg_username());
        UnfollowOrgResponseModel responseModel = new UnfollowOrgResponseModel(requestModel.getOrg_username());
        return unfollowOrgPresenter.prepareSuccessPage(responseModel);

    }
}
