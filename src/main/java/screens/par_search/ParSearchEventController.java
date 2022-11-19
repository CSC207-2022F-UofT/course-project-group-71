package screens.par_search;

import par_search_event_use_case.ParSearchEventInputBoundary;
import par_search_event_use_case.ParSearchEventRequestModel;
import par_search_event_use_case.ParSearchEventResponseModel;

import java.sql.SQLException;

public class ParSearchEventController {


    final ParSearchEventInputBoundary userInput;

    public ParSearchEventController(ParSearchEventInputBoundary userInput) {
        this.userInput = userInput;
    }

    public ParSearchEventResponseModel eventSearch(String query, String parUserName) throws SQLException, ClassNotFoundException {
        ParSearchEventRequestModel requestModel = new ParSearchEventRequestModel(query,parUserName);
        return userInput.eventSearch(requestModel);
    }


}
