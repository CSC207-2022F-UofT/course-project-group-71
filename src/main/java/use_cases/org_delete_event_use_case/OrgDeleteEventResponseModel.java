package use_cases.org_delete_event_use_case;

/** The response model sent back to the page.
 *  Containing the username and the message.
 */
public class OrgDeleteEventResponseModel {
    String eventName;
    String message;

    /**This is the construct method of OrgDeleteEventResponseModel, it took an eventName and store it as instance.
     *
     * @param eventName Name of event
     */
    public OrgDeleteEventResponseModel(String eventName) {
        this.eventName = eventName;
    }

    /**This is a method to set the message sent back
     *
     * @param message The message to be set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**This is a method to get the eventName chosen by org.
     *
     * @return The eventName used for deletion
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
