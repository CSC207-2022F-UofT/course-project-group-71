package use_cases.par_search_event_use_case;

import controller_presenter_view.screens.par_home.par_search.ParSearchEventResultsPage;
import use_cases.par_search_event_use_case.ParSearchEventOutputBoundary;
import use_cases.par_search_event_use_case.ParSearchEventResponseModel;
import controller_presenter_view.common_view.ShowMessageView;

import java.util.ArrayList;

public class ParSearchEventPresenter implements ParSearchEventOutputBoundary {

    /**Returns the search results of a successful search.
     *
     * @param results A response model containing information to show success view
     * @return Returns the response model
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    @Override
    public ParSearchEventResponseModel prepareSuccessView(ParSearchEventResponseModel results) throws ClassNotFoundException {
        ArrayList<String> eventNames= results.getSearchResults();
        String parUserName= results.getParUserName();
        new ParSearchEventResultsPage(eventNames,parUserName);
        return results;
    }

    /**Returns an error due to a failed search.
     *
     * @param error A String containing information about how it failed
     * @return Throws an error
     */
    @Override
    public ParSearchEventResponseModel prepareFailView(String error) {throw new ShowMessageView(error);
    }
}
