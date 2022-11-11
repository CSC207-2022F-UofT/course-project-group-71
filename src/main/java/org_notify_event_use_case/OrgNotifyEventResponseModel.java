package org_notify_event_use_case;

public class OrgNotifyEventResponseModel {
    String eventName;
    String message;

    public OrgNotifyEventResponseModel(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){return this.message;}

}