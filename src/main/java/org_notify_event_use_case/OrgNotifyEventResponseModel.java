package org_notify_event_use_case;

/** The response model sent back to the page.
 *  Containing the eventName and the message.
 */
public class OrgNotifyEventResponseModel {
    String eventName;
    String message;

    /**This is the construct method of OrgNotifyEventResponseModel, it took an eventName and store it as instance.
     *
     * @param eventName The event name of event which notifications will be sent out.
     */
    public OrgNotifyEventResponseModel(String eventName) {
        this.eventName = eventName;
    }

    /**This is a method to get the eventName.
     *
     * @return The event name used for sending notifications
     */
    public String getEventName() {
        return eventName;
    }

    /**This is a method to set the message sent back
     *
     * @param message The message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**This is a method to get the message sent back
     *
     * @return The message sent back
     */
    public String getMessage(){return this.message;}

}