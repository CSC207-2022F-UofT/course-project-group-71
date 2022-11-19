package par_search_org_use_case;

import database.OrgDsGateway;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParSearchOrgInteractor implements ParSearchOrgInputBoundary {

    final OrgDsGateway orgDsGateway;
    final ParSearchOrgOutputBoundary userOutput;

    /**This is the construct method of ParSearchOrgInteractor.
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param orgDsGateway The database gateway of the organizers
     * @param userOutput The presenter used to show success or not of org search
     */
    public ParSearchOrgInteractor(OrgDsGateway orgDsGateway, ParSearchOrgOutputBoundary userOutput) {
        this.orgDsGateway = orgDsGateway;
        this.userOutput = userOutput;
    }

    /**Use the information contained in the userInput to search an event and create a responsemodel.
     * It retrieves all organizers that contain the string userInput and store it in searchResults.
     * It retrieves parUserName.
     * If searchResults is empty, return failure response.
     * Otherwise, It creates responseModel using searchResults and parUserName.(need parUserName to determine leave/join)
     * Success response is returned.
     *
     * @param userInput The request model sent to the interactor
     * @return userOutput representing whether the org search is successful
     */
    @Override
    public ParSearchOrgResponseModel orgSearch(ParSearchOrgRequestModel userInput) throws SQLException, ClassNotFoundException {
        ArrayList<String> searchResults = orgDsGateway.organizerSearch(userInput.getQuery());
        String parUserName= userInput.getParUserName();
        if (searchResults.isEmpty()) {
            return userOutput.prepareFailView("No organizers found.");
        } else {
            ParSearchOrgResponseModel responseModel = new ParSearchOrgResponseModel(searchResults,parUserName);
            return userOutput.prepareSuccessView(responseModel);
        }
    }
}
