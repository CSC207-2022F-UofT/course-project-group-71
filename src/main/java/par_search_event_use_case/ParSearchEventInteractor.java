package par_search_event_use_case;

import database.EventDsGateway;


import java.sql.SQLException;
import java.util.ArrayList;

public class ParSearchEventInteractor implements ParSearchEventInputBoundary {

    final EventDsGateway eventDsGateway;
    final ParSearchEventOutputBoundary userOutput;

    public ParSearchEventInteractor(EventDsGateway eventDsGateway, ParSearchEventOutputBoundary userOutput) {
        this.eventDsGateway = eventDsGateway;
        this.userOutput = userOutput;
    }


    @Override
    public ParSearchEventResponseModel eventSearch(ParSearchEventRequestModel userInput) throws SQLException, ClassNotFoundException {
        ArrayList<String> searchResults = eventDsGateway.eventSearch(userInput.getQuery());
        String parUserName= userInput.getParUserName();
        if (searchResults.isEmpty()) {
            return userOutput.prepareFailView("No events found.");
        } else {
            ParSearchEventResponseModel responseModel = new ParSearchEventResponseModel(searchResults, parUserName);
            return userOutput.prepareSuccessView(responseModel);
        }
    }
}


