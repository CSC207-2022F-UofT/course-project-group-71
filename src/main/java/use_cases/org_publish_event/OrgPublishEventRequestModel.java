package use_cases.org_publish_event;

/** The request model of event publishing.
 *  Contains eventName.
 */
public class OrgPublishEventRequestModel {
    final String eventTitle;
    final String orgUsername;

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
