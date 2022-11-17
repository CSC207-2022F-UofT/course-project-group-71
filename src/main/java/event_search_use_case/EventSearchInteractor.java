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
    public EventSearchResponseModel eventSearch(EventSearchRequestModel requestModel) {
            ArrayList<String> searchResults = eventDsGateway.eventSearch(requestModel.getQuery());
            if (searchResults.isEmpty()) {
                return userOutput.prepareFailView("No organizers found.");
            } else {
                EventSearchResponseModel responseModel = new EventSearchResponseModel (searchResults);
                return userOutput.prepareSuccessView(responseModel);
            }
        }

    }


