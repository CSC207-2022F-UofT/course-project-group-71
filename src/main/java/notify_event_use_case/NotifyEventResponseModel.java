package notify_event_use_case;

/** The response model sent back to the page.
 *  Containing the eventName and the message.
 */
public class NotifyEventResponseModel {
    String eventName;
    String notificationType;//It could be "Past" or "Future"
    String message;

    public NotifyEventResponseModel(String eventName, String notificationType) {
        this.eventName = eventName;
        this.notificationType = notificationType;
    }

    public String getEventName() {
        return eventName;
    }

    public String getNotificationType(){return notificationType;}//It could be "Past" or "Future"

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){return this.message;}

}