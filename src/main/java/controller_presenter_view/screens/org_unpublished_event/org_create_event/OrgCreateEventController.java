package controller_presenter_view.screens.org_unpublished_event.org_create_event;

import org_create_event_use_case.OrgCreateEventInputBoundary;
import org_create_event_use_case.OrgCreateEventRequestModel;
import org_create_event_use_case.OrgCreateEventResponseModel;

import java.sql.SQLException;

public class OrgCreateEventController {

    OrgCreateEventInputBoundary userInput;

    public OrgCreateEventController(OrgCreateEventInputBoundary userInput) {
        //Store the interactor of the controller
        this.userInput = userInput;
    }

    public OrgCreateEventResponseModel create(String orgUsername,
                                              String title,
                                              String description,
                                              String location,
                                              String year,
                                              String month,
                                              String day,
                                              String hour,
                                              String minute) throws SQLException, ClassNotFoundException {
        //Generate a request model which would be sent to the interactor
        OrgCreateEventRequestModel requestModel = new OrgCreateEventRequestModel(
                orgUsername, title, description, location, year, month, day, hour, minute);

        //Return the response model returned from interactor method
        return userInput.create(requestModel);
    }

}
