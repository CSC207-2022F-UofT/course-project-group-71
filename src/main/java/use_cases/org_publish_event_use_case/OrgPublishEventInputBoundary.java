package use_cases.org_publish_event_use_case;

/** Interface implements by interactor.
 * The interactor who implement the interface must have publish() method.
 */
public interface OrgPublishEventInputBoundary {

    /**Use the information contained in the request model to publish an event and respond a response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A response model representing whether the event publishing is successful
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    OrgPublishEventResponseModel publish(OrgPublishEventRequestModel requestModel) throws ClassNotFoundException;
}
