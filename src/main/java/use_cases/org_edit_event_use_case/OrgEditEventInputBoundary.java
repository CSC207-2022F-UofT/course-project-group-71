package use_cases.org_edit_event_use_case;

/** Interface implements by interactor.
 * The interactor who implement the interface must have edit() method.
 */
public interface OrgEditEventInputBoundary {
    /**Use the information contained in the request model to edit an event and respond a response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A response model representing whether the event editing is successful
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    OrgEditEventResponseModel edit(OrgEditEventRequestModel requestModel) throws ClassNotFoundException;
}
