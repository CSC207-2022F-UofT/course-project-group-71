package org_notify_event_use_case;

public interface OrgNotifyEventOutputBoundary {
    OrgNotifyEventResponseModel prepareSuccessView(OrgNotifyEventResponseModel notificationResponseModel);

    OrgNotifyEventResponseModel prepareFailView(OrgNotifyEventResponseModel notificationResponseModel);
}