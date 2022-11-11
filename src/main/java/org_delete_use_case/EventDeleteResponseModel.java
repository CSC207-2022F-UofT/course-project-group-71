package org_delete_use_case;

public class EventDeleteResponseModel {
    String eventName;
    String message;

    public EventDeleteResponseModel(String eventName) {
        this.eventName = eventName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEventName() {
        return eventName;
    }
}
