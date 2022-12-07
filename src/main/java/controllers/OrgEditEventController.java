package controllers;

import use_cases.org_edit_event_use_case.OrgEditEventInputBoundary;
import use_cases.org_edit_event_use_case.OrgEditEventRequestModel;
import use_cases.org_edit_event_use_case.OrgEditEventResponseModel;

public class OrgEditEventController {

    final OrgEditEventInputBoundary userInput;

    public OrgEditEventController(OrgEditEventInputBoundary userInput) {
        this.userInput = userInput;
    }

    public OrgEditEventResponseModel edit(String title,
                                              String description,
                                              String location,
                                              String year,
                                              String month,
                                              String day,
                                              String hour,
                                              String minute) throws ClassNotFoundException {
        //Prepare a request model with given information
        OrgEditEventRequestModel requestModel = new OrgEditEventRequestModel(
                title, description, location, year, month, day, hour, minute);
        return userInput.edit(requestModel);
    }

}
