package org_notify_event_use_case;


public class OrgNotifyEventRequestModel {

    private String notificationType;
    private String eventName;

    public OrgNotifyEventRequestModel(String notificationType, String eventName) {
        this.notificationType = notificationType;
        this.eventName = eventName;
    }

    String getNotificationType(){ return notificationType;}
    String getEventName() {
        return eventName;
    }

}