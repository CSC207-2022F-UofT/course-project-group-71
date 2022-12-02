package use_cases.org_create_event_use_case;

<<<<<<< HEAD
import java.sql.SQLException;

=======
>>>>>>> main
/** Interface implemented by the interactor (OrgCreateEventInteractor).
 * The interactor that implements this must have the create() method.
 */
public interface OrgCreateEventInputBoundary {
    /**Use the information within the request model to create a new event and return a response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A response model representing whether the event creation is successful
     */
<<<<<<< HEAD
    OrgCreateEventResponseModel create(OrgCreateEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
=======
    OrgCreateEventResponseModel create(OrgCreateEventRequestModel requestModel) throws ClassNotFoundException;
>>>>>>> main
}
