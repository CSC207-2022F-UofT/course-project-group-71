package use_cases.par_search_event_use_case;

import database.EventDsGateway;


import java.sql.SQLException;
import java.util.ArrayList;

public class ParSearchEventInteractor implements ParSearchEventInputBoundary {

    EventDsGateway eventDsGateway;
    ParSearchEventOutputBoundary userOutput;

    /**Constructor
     *
     * @param eventDsGateway The database gateway of the events
     * @param userOutput The presenter used to show success or not of event search
     */

    public ParSearchEventInteractor(EventDsGateway eventDsGateway, ParSearchEventOutputBoundary userOutput) {
        this.eventDsGateway = eventDsGateway;
        this.userOutput = userOutput;
    }

    /**This method retrieves all events that contain the string userInput in their titles.
     * If userInput is an empty string, it retrieves all upcoming events in database.
     *
     * @param userInput The request model sent to the interactor
     * @return userOutput representing whether the event search is successful
     */
    @Override
    public ParSearchEventResponseModel eventSearch(ParSearchEventRequestModel userInput) throws SQLException, ClassNotFoundException {
        ArrayList<String> searchResults = eventDsGateway.eventSearch(userInput.getQuery());
        if (searchResults.isEmpty()) {
            return userOutput.prepareFailView("No event found.");
        } else {
            ParSearchEventResponseModel responseModel =
                    new ParSearchEventResponseModel(searchResults, userInput.getParUserName());
            return userOutput.prepareSuccessView(responseModel);
        }
    }
}


