package org_create_event_use_case;

import java.sql.SQLException;

/** Interface implements by interactor.
 * The interactor who implement the interface must have create() method.
 */
public interface OrgCreateEventInputBoundary {
    /**Use the information contained in the requestmodel to create a new event and respond a responsemodel.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responsemodel representing whether the event creation is successful
     */
    OrgCreateEventResponseModel create(OrgCreateEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
