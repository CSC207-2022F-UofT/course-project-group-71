package Par_Join_Event_Use_Case;

public class ParJoinEventRequestModel {
    String parUsername;
    String eventTitle;

    /** A request model sent the interactor to let participants join an event.
     *
     * @param parUsername The participant username
     * @param eventTitle The event title that a participant want to join
     */
    public ParJoinEventRequestModel(String parUsername, String eventTitle) {
        this.parUsername = parUsername;
        this.eventTitle = eventTitle;
    }

    /** A method to get the name of the participant from the request model.
     *
     * @return Name of the participant that wanted to join the event
     */
    public String getParUsername() {
        return parUsername;
    }

    public String getEventTitle() {
        return eventTitle;
    }
}