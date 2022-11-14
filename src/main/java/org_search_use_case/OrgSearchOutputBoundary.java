package org_search_use_case;

public interface OrgSearchOutputBoundary {
    void prepareSuccessView(OrgSearchResponseModel responseModel);

    void prepareFailView(String error);
}
