package use_cases.par_search_org_use_case;

import database.OrgDsGateway;

import java.util.ArrayList;

public class ParSearchOrgInteractor implements ParSearchOrgInputBoundary {

    final OrgDsGateway orgDsGateway;
    final ParSearchOrgOutputBoundary userOutput;

    /**Constructor
     *
     * @param orgDsGateway The database gateway of the organizers
     * @param userOutput The presenter used to show success or not of org search
     */
    public ParSearchOrgInteractor(OrgDsGateway orgDsGateway, ParSearchOrgOutputBoundary userOutput) {
        this.orgDsGateway = orgDsGateway;
        this.userOutput = userOutput;
    }

    /**This method retrieves all organizations that contain the string userInput in their usernames.
     * If userInput is an empty string, it retrieves all organizations in database.
     *
     * @param userInput The request model sent to the interactor
     * @return userOutput representing whether the org search is successful
     */
    @Override
    public ParSearchOrgResponseModel orgSearch(ParSearchOrgRequestModel userInput) throws ClassNotFoundException {
        ArrayList<String> searchResults = orgDsGateway.organizationSearch(userInput.getQuery());
        if (searchResults.isEmpty()) {
            return userOutput.prepareFailView("No organization found.");
        } else {
            ParSearchOrgResponseModel responseModel =
                    new ParSearchOrgResponseModel(searchResults, userInput.getParUserName());
            return userOutput.prepareSuccessView(responseModel);
        }
    }
}
