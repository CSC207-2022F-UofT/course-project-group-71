package org_publish_event_use_case;

/** The request model of event publishing.
 *  Contains eventName.
 */
public class OrgPublishEventRequestModel {
    String eventTitle;
    String orgUsername;

    public OrgPublishEventRequestModel(String eventTitle, String orgUsername) {
        this.eventTitle = eventTitle;
        this.orgUsername = orgUsername;
    }

    public String getEventTitle() {
        return this.eventTitle;
    }

    public String getOrgUsername(){
        return this.orgUsername;
    }
}
