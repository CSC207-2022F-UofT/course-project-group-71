package org_delete_event_use_case;

import java.sql.SQLException;

/** Interface implements by interactor.
 * The interactor who implement the interface must have delete() method.
 */
public interface OrgDeleteEventInputBoundary {
    /**Use the information contained in the request model to delete an event and respond a response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A response model representing whether the user creation is successful
     */
    OrgDeleteEventResponseModel delete(OrgDeleteEventRequestModel requestModel) throws SQLException;
}
