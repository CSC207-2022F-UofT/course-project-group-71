package par_follow_org_use_case;

import database.ParDsGateway;

import java.sql.SQLException;

public class ParFollowOrgInteractor implements ParFollowOrgInputBoundary {

    ParDsGateway parDsGateway;
    ParFollowOrgOutputBoundary parFollowOrgOutputBoundary;

    /**Constructor
     *
     * @param parFollowOrgOutputBoundary The OutputBoundary used to show successful view when following successes.
     * @param parDsGateway The participants gateway of the participants.
     */
    public ParFollowOrgInteractor(ParDsGateway parDsGateway, ParFollowOrgOutputBoundary parFollowOrgOutputBoundary){
        this.parDsGateway = parDsGateway;
        this.parFollowOrgOutputBoundary = parFollowOrgOutputBoundary;
    }

    /**Use the provided method in parDsGateway to make a participant follow an organization.
     * This method is called when the participant is searching for organizations.
     * Precondition: the participant is not following the organization
     *
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the user followed an organization successfully by the presenter.
     */
    public ParFollowOrgResponseModel follow(ParFollowOrgRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.followOrg(requestModel.getParUsername(),requestModel.getOrgUsername());
        ParFollowOrgResponseModel responseModel = new ParFollowOrgResponseModel(requestModel.getOrgUsername());
        return parFollowOrgOutputBoundary.prepareSuccessPage(responseModel);
    }
}
