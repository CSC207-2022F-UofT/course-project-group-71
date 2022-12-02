package controller_presenter_view.screens.org_unpublished_event.org_create_event;

import use_cases.org_create_event_use_case.OrgCreateEventInputBoundary;
import use_cases.org_create_event_use_case.OrgCreateEventRequestModel;
import use_cases.org_create_event_use_case.OrgCreateEventResponseModel;

<<<<<<< HEAD
import java.sql.SQLException;

public class OrgCreateEventController {

    OrgCreateEventInputBoundary userInput;

    public OrgCreateEventController(OrgCreateEventInputBoundary userInput) {
        //Store the interactor of the controller
        this.userInput = userInput;
=======
public class OrgCreateEventController {

    final OrgCreateEventInputBoundary USER_INPUT;

    public OrgCreateEventController(OrgCreateEventInputBoundary USER_INPUT) {
        //Store the interactor of the controller
        this.USER_INPUT = USER_INPUT;
>>>>>>> main
    }

    public OrgCreateEventResponseModel create(String orgUsername,
                                              String title,
                                              String description,
                                              String location,
                                              String year,
                                              String month,
                                              String day,
                                              String hour,
<<<<<<< HEAD
                                              String minute) throws SQLException, ClassNotFoundException {
=======
                                              String minute) throws ClassNotFoundException {
>>>>>>> main
        //Generate a request model which would be sent to the interactor
        OrgCreateEventRequestModel requestModel = new OrgCreateEventRequestModel(
                orgUsername, title, description, location, year, month, day, hour, minute);

        //Return the response model returned from interactor method
<<<<<<< HEAD
        return userInput.create(requestModel);
=======
        return USER_INPUT.create(requestModel);
>>>>>>> main
    }

}
