package org_search_use_case;

import database.OrgDsGateway;

import java.util.ArrayList;

public class OrgSearchInteractor implements OrgSearchInputBoundary {

    final OrgDsGateway orgDsGateway;
    final OrgSearchOutputBoundary userOutput;

    public OrgSearchInteractor(OrgDsGateway orgDsGateway, OrgSearchOutputBoundary userOutput) {
        this.orgDsGateway = orgDsGateway;
        this.userOutput = userOutput;
    }

    @Override
    public OrgSearchResponseModel orgSearch(OrgSearchRequestModel userInput) {
        ArrayList<String> searchResults = orgDsGateway.organizerSearch(userInput.getQuery());
        String parUserName= userInput.getParUserName();
        if (searchResults.isEmpty()) {
            return userOutput.prepareFailView("No organizers found.");
        } else {
            OrgSearchResponseModel responseModel = new OrgSearchResponseModel(searchResults,parUserName);
            return userOutput.prepareSuccessView(responseModel);
        }
    }
}
