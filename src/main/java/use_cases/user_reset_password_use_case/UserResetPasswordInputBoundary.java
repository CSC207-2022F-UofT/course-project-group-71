package use_cases.user_reset_password_use_case;

import java.sql.SQLException;

/** Interface implements by interactor.
 * The interactor who implement the interface must have resetPassword() method.
 */
public interface UserResetPasswordInputBoundary {

    /** Use the information contained in the request model can let user reset their password and response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responsemodel representing whether the user resetPassword is successful.
     */
    UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
