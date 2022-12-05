package use_cases.par_unfollow_org_use_case;

import database.ParDsGateway;

public class ParUnfollowOrgInteractor implements ParUnfollowOrgInputBoundary {

    final ParDsGateway parDsGateway;
    final ParUnfollowOrgOutputBoundary unfollowOrgOutputBoundary;

    /**Constructor
     *
     * @param unfollowOrgOutputBoundary The presenter used to show successful view when unfollowing successes.
     * @param parDsGateway The participants gateway of the participants.
     */
    public ParUnfollowOrgInteractor(ParDsGateway parDsGateway, ParUnfollowOrgOutputBoundary unfollowOrgOutputBoundary){
        this.parDsGateway = parDsGateway;
        this.unfollowOrgOutputBoundary = unfollowOrgOutputBoundary;
    }

    /**Use the provided method from parDsGateway to make a participant unfollow an organization
     *
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the user unfollowed an organizer successfully by the presenter.
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ParUnfollowOrgResponseModel unfollow(ParUnfollowOrgRequestModel requestModel) throws ClassNotFoundException {
        parDsGateway.unfollowOrg(requestModel.getPar_username(),requestModel.getOrg_username());
        ParUnfollowOrgResponseModel responseModel = new ParUnfollowOrgResponseModel(requestModel.getOrg_username());
        return unfollowOrgOutputBoundary.prepareSuccessPage(responseModel);
    }
}
