package notify_event_use_case;

/** The response model sent back to the page.
 *  Containing the eventName and the message.
 */
public class NotifyEventResponseModel {
    String eventName;
    String notificationType;
    String message;

    /**This is the construct method of NotifyEventResponseModel, it took an eventName and store it as instance.
     *
     * @param eventName The event name of event which notifications will be sent out.
     */
    public NotifyEventResponseModel(String eventName, String notificationType) {
        this.eventName = eventName;
        this.notificationType = notificationType;
    }

    /**This is a method to get the eventName.
     *
     * @return The event name used for sending notifications
     */
    public String getEventName() {
        return eventName;
    }

    public String getNotificationType(){return notificationType;}

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