package org_delete_use_case;

public class EventDeleteRequestModel {

    private String eventName;
    public EventDeleteRequestModel(String eventName) {
        this.eventName = eventName;
    }
    public String getEventName() {
        return eventName;
    }
}
