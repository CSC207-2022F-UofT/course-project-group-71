package org_publish_event_use_case;

public class OrgPublishEventRequestModel {
    private String eventName;
    public OrgPublishEventRequestModel(String eventName) {
        this.eventName = eventName;
    }
    public String getEventName() {
        return eventName;
    }

}
