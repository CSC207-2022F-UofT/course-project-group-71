package org_search_use_case;

public class OrgSearchPresenter implements OrgSearchOutputBoundary {

    final OrgSearchViewModel viewModel;

    public OrgSearchPresenter(OrgSearchViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(OrgSearchResponseModel responseModel) {
        // TODO: Create success view
    }

    @Override
    public void prepareFailView(String error) {
        // TODO: Create OrgSearchFailed
        throw new OrgSearchFailed(error);
    }
}
