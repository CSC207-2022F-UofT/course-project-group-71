package participant_leave_the_event;

public class EventLeaveResponseModel {
    private String par_username;

    private String event_title;

    private String message;

    public EventLeaveResponseModel(String par_username, String event_title, String message) {
        this.par_username = par_username;
        this.event_title = event_title;
        this.message = message;
    }

    public String getPar_username() {
        return par_username;
    }
    public void setPar_username(String name) {
        this.par_username = par_username;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String name) {
        this.message = message;
    }

}


