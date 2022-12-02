package use_cases.org_delete_event_use_case;

/** The request model of org_delete_event.
 *  Contains eventName.
 */
public class OrgDeleteEventRequestModel {

    final String eventName;

    /**A request model sent the interactor to delete an event.
     *
     * @param eventName Name of event.
     */
    public OrgDeleteEventRequestModel(String eventName) {
        this.eventName = eventName;
    }
    /**A method to get the name of the event from the request model.
     *
     * @return eventName
     */
    public String getEventName() {
        return eventName;
    }
}
