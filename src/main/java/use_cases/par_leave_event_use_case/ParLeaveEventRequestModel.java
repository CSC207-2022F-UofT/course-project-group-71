package use_cases.par_leave_event_use_case;

public class ParLeaveEventRequestModel {
    String par_username;
    String event_title;

    /** A request model sent the interactor to let participants leave an event.
     *
     * @param par_username The participant username
     * @param event_title The event title that a participant have taken and want to leave
     */

    public ParLeaveEventRequestModel(String par_username, String event_title) {
        this.par_username = par_username;
        this.event_title = event_title;
    }

    /** A method to get the name of the participant from the request model.
     *
     * @return Name of the participant currently want to leave
     */
    public String getPar_username() {
        return par_username;
    }

    public void setPar_username(String par_username) {
        this.par_username = par_username;
    }


    public String getEvent_title() {
        return event_title;
    }
}
