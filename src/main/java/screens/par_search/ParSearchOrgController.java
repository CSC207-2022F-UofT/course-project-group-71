package screens.par_search;

import par_search_org_use_case.ParSearchOrgInputBoundary;
import par_search_org_use_case.ParSearchOrgRequestModel;
import par_search_org_use_case.ParSearchOrgResponseModel;

import java.sql.SQLException;

public class ParSearchOrgController {

    final ParSearchOrgInputBoundary userInput;

    public ParSearchOrgController(ParSearchOrgInputBoundary userInput) {
        this.userInput = userInput;
    }

    public ParSearchOrgResponseModel orgSearch(String query, String parUserName) throws SQLException, ClassNotFoundException {
        ParSearchOrgRequestModel requestModel = new ParSearchOrgRequestModel(query,parUserName);
        return userInput.orgSearch(requestModel);
    }
}
