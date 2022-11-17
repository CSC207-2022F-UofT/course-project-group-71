package screens.org_unpublished_event;

import org_create_event_use_case.OrgCreateEventInputBoundary;
import org_create_event_use_case.OrgCreateEventRequestModel;
import org_create_event_use_case.OrgCreateEventResponseModel;

public class OrgCreateEventController {

    final OrgCreateEventInputBoundary userInput;

    public OrgCreateEventController(OrgCreateEventInputBoundary userInput) {
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
                                              String minute){
        OrgCreateEventRequestModel requestModel = new OrgCreateEventRequestModel(
                orgUsername, title, description, location, year, month, day, hour, minute);
        return userInput.create(requestModel);
    }

}
