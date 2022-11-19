package org_publish_event_use_case;

/** The request model of event publishing.
 *  Contains eventName.
 */
public class OrgPublishEventRequestModel {
    private String eventName;

    /**A request model sent the interactor to create a user.
     *
     * @param eventName The name of event about to be published
     */
    public OrgPublishEventRequestModel(String eventName) {
        this.eventName = eventName;
    }

    /**A method to get the name of the event from the request model。
     *
     * @return Name of the event currently publishing
     */
    public String getEventName() {
        return eventName;
    }

}
