package use_cases.org_publish_event_use_case;

import java.sql.SQLException;

/** Interface implements by interactor.
 * The interactor who implement the interface must have publish() method.
 */
public interface OrgPublishEventInputBoundary {

    /**Use the information contained in the requestmodel to publish an event and respond a responsemodel.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responsemodel representing whether the event publishing is successful
     */
    OrgPublishEventResponseModel publish(OrgPublishEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
