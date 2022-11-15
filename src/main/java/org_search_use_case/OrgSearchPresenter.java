//package org_search_use_case;
//
//import screens.search_screens.OrganizerResultsPage;
//
//import java.util.ArrayList;
//
//public class OrgSearchPresenter implements OrgSearchOutputBoundary {
//
//    final OrganizerResultsPage viewModel;
//
//    public OrgSearchPresenter(OrganizerResultsPage viewModel) {
//        this.viewModel = viewModel;
//    }
//
//    @Override
//    public void prepareSuccessView(OrgSearchResponseModel responseModel) {
//        ArrayList<String> orgNames= responseModel.getSearchResults();
//        OrganizerResultsPage page = new OrganizerResultsPage(orgNames);
//    }
//
//    @Override
//    public void prepareFailView(String error) {
//        // TODO: Create OrgSearchFailed
//        throw new OrgSearchFailed(error);
//    }
//}
