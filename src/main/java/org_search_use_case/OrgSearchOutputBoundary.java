package org_search_use_case;

public interface OrgSearchOutputBoundary {
    OrgSearchResponseModel prepareSuccessView(OrgSearchResponseModel results );
    OrgSearchResponseModel prepareFailView(String error);

}
