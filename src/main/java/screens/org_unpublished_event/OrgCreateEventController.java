package screens.org_unpublished_event;

import org_create_event_use_case.OrgCreateEventInputBoundary;
import org_create_event_use_case.OrgCreateEventRequestModel;

public class OrgCreateEventController {

    final OrgCreateEventInputBoundary userInput;

    public OrgCreateEventController(OrgCreateEventInputBoundary userInput) {
        this.userInput = userInput;
    }

    public void create(String orgUsername,
                       String title,
                       int status,
                       String description,
                       String location,
                       int year,
                       int month,
                       int day,
                       int hour,
                       int minute){
        OrgCreateEventRequestModel requestModel = new OrgCreateEventRequestModel(
                orgUsername, title, status, description, location, year, month, day, hour,
                minute);
        userInput.create(requestModel);
    }


}
