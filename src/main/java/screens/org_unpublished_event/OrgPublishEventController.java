package screens.org_unpublished_event;

import org_publish_event_use_case.OrgPublishEventInputBoundary;
import org_publish_event_use_case.OrgPublishEventRequestModel;
import org_publish_event_use_case.OrgPublishEventResponseModel;

public class OrgPublishEventController {
    final OrgPublishEventInputBoundary userInput;
    //
    public OrgPublishEventController(OrgPublishEventInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public OrgPublishEventResponseModel publish(String eventName) {
        OrgPublishEventRequestModel requestModel = new OrgPublishEventRequestModel(eventName);
        return userInput.publish(requestModel);
    }
//    final OrgDeleteEventInputBoundary userInput;
//
//    public OrgPublishEventController(OrgDeleteEventInputBoundary accountGateway) {
//        this.userInput = accountGateway;
//    }
//
//    public OrgDeleteEventResponseModel delete(String eventName) {
//        OrgDeleteEventRequestModel requestModel = new OrgDeleteEventRequestModel(eventName);
//        return userInput.delete(requestModel);
//    }

}
