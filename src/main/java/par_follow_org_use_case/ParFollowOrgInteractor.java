package par_follow_org_use_case;

import database.ParDsGateway;

import java.sql.SQLException;

public class ParFollowOrgInteractor implements ParFollowOrgInputBoundary {

    ParDsGateway parDsGateway;
    ParFollowOrgOutputBoundary followOrgPresenter;

    /**This is the construct method of ParFollowOrgInteractor.
     * It takes ParGateways and Presenter as input to store as instances.
     *
     * @param followOrgPresenter The presenter used to show successful view when following successes.
     * @param parDsGateway The participants gateway of the participants.
     */
    public ParFollowOrgInteractor(ParDsGateway parDsGateway, ParFollowOrgOutputBoundary followOrgPresenter){
        this.parDsGateway=parDsGateway;
        this.followOrgPresenter= followOrgPresenter;
    }

    /**Use the information contained in the requestModel to check with database and respond a responseModel.
     * It took the request model and calls the followOrg method in parDsGateway with the function
     * getPar_username and getOrg_username in the request model.
     * Then it returns the successful view by the presenter
     *
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the user followed an organizer successfully by the presenter.
     */
    public ParFollowOrgResponseModel follow(ParFollowOrgRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.followOrg(requestModel.getPar_username(),requestModel.getOrg_username());
        ParFollowOrgResponseModel responseModel = new ParFollowOrgResponseModel(requestModel.getOrg_username());
        return followOrgPresenter.prepareSuccessPage(responseModel);
    }
}
