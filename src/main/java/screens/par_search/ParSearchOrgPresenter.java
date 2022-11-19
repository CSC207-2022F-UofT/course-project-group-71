package screens.par_search;

import par_search_org_use_case.ParSearchOrgOutputBoundary;
import par_search_org_use_case.ParSearchOrgResponseModel;
import screens.ShowMessageView;

import java.util.ArrayList;


public class ParSearchOrgPresenter implements ParSearchOrgOutputBoundary {

    @Override
    public ParSearchOrgResponseModel prepareSuccessView(ParSearchOrgResponseModel results) {
        ArrayList<String> orgNames= results.getSearchResults();
        String parUserName= results.getParUserName();
        new ParSearchOrgResultsPage(orgNames,parUserName);
        return results;
    }

    @Override
    public ParSearchOrgResponseModel prepareFailView(String error) {
        throw new ShowMessageView(error);
    }
}
