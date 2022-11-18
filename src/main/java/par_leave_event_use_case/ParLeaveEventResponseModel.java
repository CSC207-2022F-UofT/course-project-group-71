package par_leave_event_use_case;

public class ParLeaveEventResponseModel {

    private String event_title;

    private String message;

    public ParLeaveEventResponseModel(String event_title, String message) {
        this.event_title = event_title;
        this.message = message;
    }

    public String getEvent_title() {
        return event_title;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String name) {
        this.message = message;
    }

}


