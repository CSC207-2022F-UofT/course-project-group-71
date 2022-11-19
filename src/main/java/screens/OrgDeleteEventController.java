package screens;

import org_delete_event_use_case.OrgDeleteEventResponseModel;
import org_delete_event_use_case.OrgDeleteEventInputBoundary;
import org_delete_event_use_case.OrgDeleteEventRequestModel;

import java.sql.SQLException;

public class OrgDeleteEventController {
    final OrgDeleteEventInputBoundary userInput;

    public OrgDeleteEventController(OrgDeleteEventInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    OrgDeleteEventResponseModel delete(String eventName) throws SQLException, ClassNotFoundException {
        OrgDeleteEventRequestModel requestModel = new OrgDeleteEventRequestModel(eventName);
        return userInput.delete(requestModel);
    }
}