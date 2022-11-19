package screens.par_search;

import event_search_use_case.EventSearchInputBoundary;
import event_search_use_case.EventSearchRequestModel;
import event_search_use_case.EventSearchResponseModel;

import java.sql.SQLException;

public class EventSearchController {


    final EventSearchInputBoundary userInput;

    public EventSearchController(EventSearchInputBoundary userInput) {
        this.userInput = userInput;
    }

    public EventSearchResponseModel eventSearch(String query, String parUserName) throws SQLException, ClassNotFoundException {
        EventSearchRequestModel requestModel = new EventSearchRequestModel(query,parUserName);
        return userInput.eventSearch(requestModel);
    }


}
