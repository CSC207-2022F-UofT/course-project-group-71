package org_publish_event_use_case;

public class OrgPublishEventResponseModel {
    String eventName;
    String message;

    public OrgPublishEventResponseModel(String eventName) {
        this.eventName = eventName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEventName() {
        return eventName;
    }

    public String getMessage() { return message; }

}
