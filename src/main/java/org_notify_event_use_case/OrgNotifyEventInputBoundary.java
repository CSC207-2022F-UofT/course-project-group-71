package org_notify_event_use_case;

public interface OrgNotifyEventInputBoundary {
    OrgNotifyEventResponseModel sendNotification(OrgNotifyEventRequestModel requestModel);
}