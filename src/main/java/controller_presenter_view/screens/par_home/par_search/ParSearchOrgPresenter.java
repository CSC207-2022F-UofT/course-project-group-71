package controller_presenter_view.screens.par_home.par_search;

import par_search_org_use_case.ParSearchOrgOutputBoundary;
import par_search_org_use_case.ParSearchOrgResponseModel;
import controller_presenter_view.common_view.ShowMessageView;

import java.util.ArrayList;


public class ParSearchOrgPresenter implements ParSearchOrgOutputBoundary {

    /**Returns the search results following a successful search for organizers.
     *
     * @param results A response model containing information to show success view
     * @return Returns the response model
     */
    @Override
    public ParSearchOrgResponseModel prepareSuccessView(ParSearchOrgResponseModel results) {
        ArrayList<String> orgNames= results.getSearchResults();
        String parUserName= results.getParUserName();
        new ParSearchOrgResultsPage(orgNames,parUserName);
        return results;
    }

    /**Returns an error due to a failed search.
     *
     * @param error A String containing information about how it failed
     * @return Throws an error
     */
    @Override
    public ParSearchOrgResponseModel prepareFailView(String error) {
        throw new ShowMessageView(error);
    }
}
