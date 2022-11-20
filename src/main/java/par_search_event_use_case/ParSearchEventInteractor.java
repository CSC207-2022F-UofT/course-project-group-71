package par_search_event_use_case;

import database.EventDsGateway;


import java.sql.SQLException;
import java.util.ArrayList;

public class ParSearchEventInteractor implements ParSearchEventInputBoundary {

    final EventDsGateway eventDsGateway;
    final ParSearchEventOutputBoundary userOutput;

    /**This is the construct method of ParSearchEventInteractor.
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param eventDsGateway The database gateway of the events
     * @param userOutput The presenter used to show success or not of event search
     */

    public ParSearchEventInteractor(EventDsGateway eventDsGateway, ParSearchEventOutputBoundary userOutput) {
        this.eventDsGateway = eventDsGateway;
        this.userOutput = userOutput;
    }

    /**Use the information contained in the userInput to search an event and create a responsemodel.
     * It retrieves all events that contain the string userInput and store it in searchResults.
     * It retrieves parUserName.
     * If searchResults is empty, return failure response.
     * Otherwise, It creates responseModel using searchResults and parUserName.(need parUserName to determine follow/unfollow)
     * Success response is returned.
     *
     * @param userInput The request model sent to the interactor
     * @return userOutput representing whether the event search is successful
     */
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


