package screens.org_upcoming_event;

import org_notify_event_use_case.OrgNotifyEventInputBoundary;
import org_notify_event_use_case.OrgNotifyEventRequestModel;
import org_notify_event_use_case.OrgNotifyEventResponseModel;

import java.sql.SQLException;

public class OrgNotifyEventController {
    final OrgNotifyEventInputBoundary orgNotifyEventInputBoundary;

    public OrgNotifyEventController(OrgNotifyEventInputBoundary accountGateway) {
        this.orgNotifyEventInputBoundary = accountGateway;
    }

    public OrgNotifyEventResponseModel sendNotification(String notificationType, String eventName) throws SQLException {
        OrgNotifyEventRequestModel requestModel = new OrgNotifyEventRequestModel(notificationType, eventName);

        return orgNotifyEventInputBoundary.sendNotification(requestModel);
    }
}
