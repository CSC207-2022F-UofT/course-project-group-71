package use_cases.par_join_event_use_case;

public class ParJoinEventResponseModel {
    final String eventName;
    String message;

    /** This is the construct method of EventLeaveResponseModel.
     *
     * @param eventName  The event name that a participant want to join.
     */
    public ParJoinEventResponseModel(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
