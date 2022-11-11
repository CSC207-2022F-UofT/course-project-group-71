package org_delete_event_use_case;

public class OrgDeleteEventRequestModel {
    private String eventName;
    public OrgDeleteEventRequestModel(String eventName) {
        this.eventName = eventName;
    }
    public String getEventName() {
        return eventName;
    }

}
