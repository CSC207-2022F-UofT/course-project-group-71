package participant_leave_the_event;

public class EventLeaveRequestModel {
    private String par_username;

    public EventLeaveRequestModel(String par_username) {
        this.par_username = par_username;
    }
    public String getPar_username() {
        return par_username;
    }

    public void setPar_username(String par_username) {
        this.par_username = par_username;
    }

}
