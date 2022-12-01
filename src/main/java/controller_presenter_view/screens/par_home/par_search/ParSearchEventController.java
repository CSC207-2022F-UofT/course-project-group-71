package controller_presenter_view.screens.par_home.par_search;

import use_cases.par_search_event_use_case.ParSearchEventInputBoundary;
import use_cases.par_search_event_use_case.ParSearchEventRequestModel;
import use_cases.par_search_event_use_case.ParSearchEventResponseModel;

import java.sql.SQLException;

public class ParSearchEventController {


    final ParSearchEventInputBoundary userInput;

    /**The controller for the participant searching for events use case.
     * It takes a user input and returns the controller.
     *
     * @param userInput The user input from the participant searching for events.
     */
    public ParSearchEventController(ParSearchEventInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**The main method that allows the participant to search for events.
     * It passes the request to search for events to the input boundary using the request model
     * data structure.
     *
     * @param query The search query
     * @param parUserName The username of the participant
     * @return Returns the response model, which is a data structure containing the search results
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ParSearchEventResponseModel eventSearch(String query, String parUserName) throws ClassNotFoundException {
        ParSearchEventRequestModel requestModel = new ParSearchEventRequestModel(query,parUserName);
        return userInput.eventSearch(requestModel);
    }


}
