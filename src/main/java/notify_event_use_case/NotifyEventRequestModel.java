package notify_event_use_case;


/** The request model of org notification.
 *  Contains notificationType and eventName.
 */
public class NotifyEventRequestModel {

    String notificationType;
    String eventName;

    /**A request model sent the interactor to send a notification.
     *
     * @param notificationType The type of notification
     * @param eventName Name of the event
     */
    public NotifyEventRequestModel(String notificationType, String eventName) {
        this.notificationType = notificationType;
        this.eventName = eventName;
    }

    /**A method to get the notification type from the request model.
     *
     * @return notification type
     */
    String getNotificationType(){ return notificationType;}
    /**A method to get the event name from the request model.
     *
     * @return Name of the event
     */
    String getEventName() {
        return eventName;
    }

}