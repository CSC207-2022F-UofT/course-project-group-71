package use_cases.notify_event_use_case;

import java.sql.SQLException;

/** Interface implements by interact.
 * The interactor who implement the interface must have sendNotification() method.
 */
public interface NotifyEventInputBoundary {
    /**Use the information contained in the request-model to notify an event and respond a response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A response model representing whether the notification is successful
     */
    NotifyEventResponseModel sendNotification(NotifyEventRequestModel requestModel) throws ClassNotFoundException;
}