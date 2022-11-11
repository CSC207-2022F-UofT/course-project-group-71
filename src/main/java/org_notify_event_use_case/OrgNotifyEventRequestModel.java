package org_notify_event_use_case;


public class OrgNotifyEventRequestModel {

    private String eventName;

    public OrgNotifyEventRequestModel(String eventName) {
        this.eventName = eventName;
    }

    String getEventName() {
        return eventName;
    }

}