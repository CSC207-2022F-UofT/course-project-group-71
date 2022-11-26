package screens.org_upcoming_event;

import org_delete_event_use_case.*;

import java.sql.SQLException;

public class OrgDeleteEventController {
    OrgDeleteEventInputBoundary userInput;

    public OrgDeleteEventController(OrgDeleteEventInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public OrgDeleteEventResponseModel delete(String eventName) throws SQLException, ClassNotFoundException {
        OrgDeleteEventRequestModel requestModel = new OrgDeleteEventRequestModel(eventName);
        return userInput.delete(requestModel);
    }

}
