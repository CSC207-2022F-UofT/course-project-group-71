package screens.search_screens;

import event_search_use_case.EventSearchInputBoundary;
import event_search_use_case.EventSearchRequestModel;

public class EventSearchController {

    final EventSearchInputBoundary userInput;

    public EventSearchController(EventSearchInputBoundary userInput) {
        this.userInput = userInput;
    }

    public void eventSearch(String query) {
        EventSearchRequestModel requestModel = new EventSearchRequestModel(query);
        userInput.eventSearch(requestModel);
    }
}
