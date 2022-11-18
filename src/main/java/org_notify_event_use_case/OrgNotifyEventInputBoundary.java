package org_notify_event_use_case;

import java.sql.SQLException;

public interface OrgNotifyEventInputBoundary {
    OrgNotifyEventResponseModel sendNotification(OrgNotifyEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}