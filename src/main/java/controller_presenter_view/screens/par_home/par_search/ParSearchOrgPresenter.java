package controller_presenter_view.screens.par_home.par_search;

import use_cases.par_search_org_use_case.ParSearchOrgOutputBoundary;
import use_cases.par_search_org_use_case.ParSearchOrgResponseModel;
import controller_presenter_view.common_view.ShowMessageView;

import java.util.ArrayList;


public class ParSearchOrgPresenter implements ParSearchOrgOutputBoundary {

    /**Returns the search results following a successful search for organizers.
     *
     * @param responseModel A response model containing information to show success view
     * @return Returns the response model
     */
    @Override
    public ParSearchOrgResponseModel prepareSuccessView(ParSearchOrgResponseModel responseModel) throws ClassNotFoundException {
        ArrayList<String> orgNames = responseModel.getSearchResults();
        String parUserName = responseModel.getParUserName();
        new ParSearchOrgResultsPage(orgNames, parUserName);
        return responseModel;
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
