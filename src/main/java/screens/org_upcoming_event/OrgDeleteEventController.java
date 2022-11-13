package screens.org_upcoming_event;

import org_delete_event_use_case.*;

public class OrgDeleteEventController {
    final OrgDeleteEventInputBoundary userInput;

    public OrgDeleteEventController(OrgDeleteEventInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public OrgDeleteEventResponseModel delete(String eventName) {
        OrgDeleteEventRequestModel requestModel = new OrgDeleteEventRequestModel(eventName);
        return userInput.delete(requestModel);
    }

}
