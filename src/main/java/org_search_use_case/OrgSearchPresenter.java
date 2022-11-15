package org_search_use_case;

import screens.ShowMessageView;
import screens.search_screens.OrganizerResultsPage;

import java.util.ArrayList;


public class OrgSearchPresenter implements OrgSearchOutputBoundary {

    @Override
    public OrgSearchResponseModel prepareSuccessView(OrgSearchResponseModel results) {
        ArrayList<String> orgNames= results.getSearchResults();
        new OrganizerResultsPage(orgNames);
        return results;
    }

    @Override
    public OrgSearchResponseModel prepareFailView(String error) {throw new ShowMessageView(error);
    }
}
