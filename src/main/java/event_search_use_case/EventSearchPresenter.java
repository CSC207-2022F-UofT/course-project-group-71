package event_search_use_case;

import screens.ShowMessageView;
import screens.search_screens.EventResultsPage;

import java.util.ArrayList;

public class EventSearchPresenter implements EventSearchOutputBoundary {


    @Override
    public EventSearchResponseModel prepareSuccessView(EventSearchResponseModel results) {
        ArrayList<String> eventNames= results.getSearchResults();
        String parUserName= results.getParUserName();
        new EventResultsPage(eventNames,parUserName);
        return results;
    }

    @Override
    public EventSearchResponseModel prepareFailView(String error) {throw new ShowMessageView(error);
    }
}
