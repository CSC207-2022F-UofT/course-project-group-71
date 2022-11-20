package org_edit_event_use_case;

import java.sql.SQLException;

/** Interface implements by interactor.
 * The interactor who implement the interface must have edit() method.
 */
public interface OrgEditEventInputBoundary {
    /**Use the information contained in the requestmodel to edit an event and respond a responsemodel.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responsemodel representing whether the event editing is successful
     */
    OrgEditEventResponseModel edit(OrgEditEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
