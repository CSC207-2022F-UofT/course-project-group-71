package org_publish_event_use_case;

/** The response model sent back to the page.
 *  Containing the eventName and the message.
 */
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
