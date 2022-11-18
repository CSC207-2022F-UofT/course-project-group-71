package par_unfollow_org_use_case;

import database.ParDsGateway;

import java.sql.SQLException;

public class UnfollowOrgInteractor implements UnfollowOrgInputBoundary {

    ParDsGateway parDsGateway;
    UnfollowOrgOutputBoundary followOrgPresenter;

    public UnfollowOrgInteractor(ParDsGateway parDsGateway, UnfollowOrgOutputBoundary followOrgPresenter){
        this.parDsGateway=parDsGateway;
        this.followOrgPresenter= followOrgPresenter;
    }

    public void follow(UnfollowOrgRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.followOrg(requestModel.getPar_username(),requestModel
                .getOrg_username());


    }
}
