package par_leave_event_use_case;

public class ParLeaveEventRequestModel {
    private String par_username;
    private String event_title;

    public ParLeaveEventRequestModel(String par_username, String event_title) {
        this.par_username = par_username;
        this.event_title = event_title;
    }
    public String getPar_username() {
        return par_username;
    }

    public void setPar_username(String par_username) {
        this.par_username = par_username;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }
}
