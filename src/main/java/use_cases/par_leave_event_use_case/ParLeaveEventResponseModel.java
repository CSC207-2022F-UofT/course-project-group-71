package use_cases.par_leave_event_use_case;

public class ParLeaveEventResponseModel {

    String event_title;

    String message;

    /** This is the construct method of EventLeaveResponseModel.
     *
     * @param event_title  The event name that a participant have taken and want to leave.
     */

    public ParLeaveEventResponseModel(String event_title) {
        this.event_title = event_title;
    }
    public String getEvent_title() {
        return event_title;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}


