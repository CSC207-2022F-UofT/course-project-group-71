package par_unfollow_org_use_case;

import database.ParDsGateway;

import java.sql.SQLException;

public class ParUnfollowOrgInteractor implements ParUnfollowOrgInputBoundary {

    ParDsGateway parDsGateway;
    ParUnfollowOrgOutputBoundary unfollowOrgPresenter;

    /**This is the construct method of ParUnfollowOrgInteractor.
     * It takes ParGateways and Presenter as input to store as instances.
     *
     * @param unfollowOrgPresenter The presenter used to show successful view when unfollowing successes.
     * @param parDsGateway The participants gateway of the participants.
     */
    public ParUnfollowOrgInteractor(ParDsGateway parDsGateway, ParUnfollowOrgOutputBoundary unfollowOrgPresenter){
        this.parDsGateway=parDsGateway;
        this.unfollowOrgPresenter= unfollowOrgPresenter;
    }

    /**Use the information contained in the requestModel to check with database and respond a responseModel.
     * It took the request model and calls the unfollowOrg method in parDsGateway with the function
     * getPar_username and getOrg_username in the request model.
     * Then it returns the successful view by the presenter
     *
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the user unfollowed an organizer successfully by the presenter.
     */
    public ParUnfollowOrgResponseModel unfollow(ParUnfollowOrgRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.unfollowOrg(requestModel.getPar_username(),requestModel
                .getOrg_username());
        ParUnfollowOrgResponseModel responseModel = new ParUnfollowOrgResponseModel(requestModel.getOrg_username());
        return unfollowOrgPresenter.prepareSuccessPage(responseModel);

    }
}
