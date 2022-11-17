package event_search_use_case;

import database.EventDsGateway;


import java.util.ArrayList;

public class EventSearchInteractor implements EventSearchInputBoundary {

    final EventDsGateway eventDsGateway;
    final EventSearchOutputBoundary userOutput;

    public EventSearchInteractor(EventDsGateway eventDsGateway, EventSearchOutputBoundary userOutput) {
        this.eventDsGateway = eventDsGateway;
        this.userOutput = userOutput;
    }


    @Override
    public EventSearchResponseModel eventSearch(EventSearchRequestModel userInput) {
        ArrayList<String> searchResults = eventDsGateway.eventSearch(userInput.getQuery());
        String parUserName= userInput.getParUserName();
        if (searchResults.isEmpty()) {
            return userOutput.prepareFailView("No events found.");
        } else {
            EventSearchResponseModel responseModel = new EventSearchResponseModel (searchResults, parUserName);
            return userOutput.prepareSuccessView(responseModel);
        }
    }
}


