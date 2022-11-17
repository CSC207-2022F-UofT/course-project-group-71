package par_register_event_use_case;

public class ParRegisterEventResponseModel {
    String eventName;
    String message;

    public ParRegisterEventResponseModel(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }
    public String getMessage() {
        return this.message;
    }

    public void setEventname(String eventName) {
        this.eventName = eventName;
    }
    public void setMessage(String message) {
        this.message = message;
    }



}
