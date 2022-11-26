package screens.notify_event;

import notify_event_use_case.NotifyEventInputBoundary;
import notify_event_use_case.NotifyEventRequestModel;
import notify_event_use_case.NotifyEventResponseModel;

import java.sql.SQLException;

public class NotifyEventController {
    final NotifyEventInputBoundary notifyEventInputBoundary;

    public NotifyEventController(NotifyEventInputBoundary accountGateway) {
        this.notifyEventInputBoundary = accountGateway;
    }

    public NotifyEventResponseModel sendNotification(String notificationType, String eventName) throws SQLException, ClassNotFoundException {
        NotifyEventRequestModel requestModel = new NotifyEventRequestModel(notificationType, eventName);

        return notifyEventInputBoundary.sendNotification(requestModel);
    }
}
