package notify_event_use_case;


/** The request model of org notification.
 *  Contains notificationType and eventName.
 */
public class NotifyEventRequestModel {

    String notificationType;//It could be "Past" or "Future"
    String eventName;

    public NotifyEventRequestModel(String notificationType, String eventName) {
        this.notificationType = notificationType;
        this.eventName = eventName;
    }

    String getNotificationType(){ return notificationType;}

    String getEventName() {
        return eventName;
    }

}