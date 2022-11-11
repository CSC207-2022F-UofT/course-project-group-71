package org_notify_event_use_case;

public interface OrgNotifyEventPresenter {
    OrgNotifyEventResponseModel prepareSuccessView(OrgNotifyEventResponseModel notificationResponseModel);

    OrgNotifyEventResponseModel prepareFailView(OrgNotifyEventResponseModel notificationResponseModel);
}