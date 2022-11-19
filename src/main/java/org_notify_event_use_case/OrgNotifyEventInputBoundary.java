package org_notify_event_use_case;

import java.sql.SQLException;

/** Interface implements by interactor.
 * The interactor who implement the interface must have sendNotification() method.
 */
public interface OrgNotifyEventInputBoundary {
    /**Use the information contained in the requestmodel to notify an event and respond a responsemodel.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responsemodel representing whether the notification is successful
     */
    OrgNotifyEventResponseModel sendNotification(OrgNotifyEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}