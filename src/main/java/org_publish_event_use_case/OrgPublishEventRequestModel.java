package org_publish_event_use_case;

/** The request model of event publishing.
 *  Contains eventName.
 */
public class OrgPublishEventRequestModel {
    String eventName;

    public OrgPublishEventRequestModel(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }

}
