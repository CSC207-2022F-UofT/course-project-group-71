package user_register_use_case;

import java.sql.SQLException;

/** Interface implements by interactor.
 * The interactor who implement the interface must have create() method.
 */
public interface UserRegisterInputBoundary {
    /**Use the information contained in the requestmodel to create a new user and respond a responsemodel.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responsemodel representing whether the user creation is successful
     */
    UserRegisterResponseModel create(UserRegisterRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
