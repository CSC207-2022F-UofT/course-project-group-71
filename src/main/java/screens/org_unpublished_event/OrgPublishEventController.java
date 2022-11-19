package screens.org_unpublished_event;

import org_publish_event_use_case.OrgPublishEventInputBoundary;
import org_publish_event_use_case.OrgPublishEventRequestModel;
import org_publish_event_use_case.OrgPublishEventResponseModel;

import java.sql.SQLException;

public class OrgPublishEventController {
    final OrgPublishEventInputBoundary userInput;
    //
    public OrgPublishEventController(OrgPublishEventInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public OrgPublishEventResponseModel publish(String eventName) throws SQLException, ClassNotFoundException {
        OrgPublishEventRequestModel requestModel = new OrgPublishEventRequestModel(eventName);
        return userInput.publish(requestModel);
    }

}
