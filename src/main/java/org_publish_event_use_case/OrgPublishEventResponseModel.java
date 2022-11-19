package org_publish_event_use_case;

/** The response model sent back to the page.
 *  Containing the eventName and the message.
 */
public class OrgPublishEventResponseModel {
    String eventName;
    String message;

    /**This is the construct method of OrgPublishEventResponseModel, it took an eventName and store it as instance.
     *
     * @param eventName The name of event about to be published
     */
    public OrgPublishEventResponseModel(String eventName) {
        this.eventName = eventName;
    }

    /**This is a method to set the message sent back
     *
     * @param message The message to be set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**This is a method to get the eventName.
     *
     * @return The name of event about to be published
     */
    public String getEventName() {
        return eventName;
    }

    /**This is a method to get the message sent back
     *
     * @return The message sent back
     */
    public String getMessage() { return message; }

}
