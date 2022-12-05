package use_cases.par_search_org_use_case;

import use_cases.par_search_org_use_case.ParSearchOrgInputBoundary;
import use_cases.par_search_org_use_case.ParSearchOrgRequestModel;
import use_cases.par_search_org_use_case.ParSearchOrgResponseModel;

public class ParSearchOrgController {

    final ParSearchOrgInputBoundary userInput;

    /**The controller for the participant searching for organizers use case.
     * It takes a user input and returns the controller.
     *
     * @param userInput The user input from the participant searching for organizers
     */
    public ParSearchOrgController(ParSearchOrgInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**The main method to search for organizers.
     *
     * @param query A string containing the participant's search query
     * @param parUserName The username of the participant
     * @return Returns a response model containing the search results
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ParSearchOrgResponseModel orgSearch(String query, String parUserName) throws ClassNotFoundException {
        ParSearchOrgRequestModel requestModel = new ParSearchOrgRequestModel(query,parUserName);
        return userInput.orgSearch(requestModel);
    }
}
