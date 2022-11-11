package screens.org_upcoming_event;

import org_notify_event_use_case.*;

import java.time.LocalDateTime;

public class OrgNotifyEventController {
    final OrgNotifyEventInputBoundary orgNotifyEventInputBoundary;

    public OrgNotifyEventController(OrgNotifyEventInputBoundary accountGateway) {
        this.orgNotifyEventInputBoundary = accountGateway;
    }

    OrgNotifyEventResponseModel sendNotification(String eventName) {
        OrgNotifyEventRequestModel requestModel = new OrgNotifyEventRequestModel(eventName);

        return orgNotifyEventInputBoundary.sendNotification(requestModel);
    }
}
