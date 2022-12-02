package use_cases.org_publish_event;

/** The response model sent back to the page.
 *  Containing the eventName and the message.
 */
public class OrgPublishEventResponseModel {
    final String eventName;
    final boolean hasFollower;
    String message;

    public OrgPublishEventResponseModel(String eventName, boolean hasFollower) {
        this.eventName = eventName;
        this.hasFollower = hasFollower;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEventName() {
        return eventName;
    }

    public String getMessage(){
        return message;
    }

    public boolean getHasFollower(){
        return hasFollower;
    }
}
