package org_delete_event_use_case;

public class OrgDeleteEventResponseModel {
    String eventName;
    String message;

    public OrgDeleteEventResponseModel(String eventName) {
        this.eventName = eventName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEventName() {
        return eventName;
    }
}
