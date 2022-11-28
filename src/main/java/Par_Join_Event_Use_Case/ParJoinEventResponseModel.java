package Par_Join_Event_Use_Case;

public class ParJoinEventResponseModel {
    final String eventName;
    final String message;

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