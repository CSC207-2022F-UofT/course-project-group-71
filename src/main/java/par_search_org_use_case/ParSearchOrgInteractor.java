package par_search_org_use_case;

import database.OrgDsGateway;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParSearchOrgInteractor implements ParSearchOrgInputBoundary {

    final OrgDsGateway orgDsGateway;
    final ParSearchOrgOutputBoundary userOutput;

    public ParSearchOrgInteractor(OrgDsGateway orgDsGateway, ParSearchOrgOutputBoundary userOutput) {
        this.orgDsGateway = orgDsGateway;
        this.userOutput = userOutput;
    }

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
