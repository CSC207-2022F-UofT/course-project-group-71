package controller_presenter_view.screens.par_account.par_reset_password;

import user_reset_password_use_case.UserResetPasswordInputBoundary;
import user_reset_password_use_case.UserResetPasswordRequestModel;
import user_reset_password_use_case.UserResetPasswordResponseModel;

import java.sql.SQLException;

public class ParResetPasswordController {
    final UserResetPasswordInputBoundary userInput;

    /**The constructor method of the controller.
     *
     * @param accountGateway The interactor of resetting password
     */

    public ParResetPasswordController(UserResetPasswordInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    /**Generatign a requestmodel and sent it to the interactor and then return the responsemodel sent
     * back from the interactor.
     *
     * @param username The username of the participant
     * @param password The old password of the participant
     * @param newPassword The new password of the participant
     * @param reNewPassword The second-input password of the participant
     * @return The responsemodel returned from the interactor
     * @throws SQLException The Exception if we SQL codes are wrong or invalid
     * @throws ClassNotFoundException The Exception if the class is not found
     */

    public UserResetPasswordResponseModel resetPassword(String username, String password, String newPassword, String reNewPassword) throws SQLException, ClassNotFoundException {
        UserResetPasswordRequestModel requestModel = new UserResetPasswordRequestModel(username, password, false, newPassword, reNewPassword);
        return userInput.resetPassword(requestModel);
    }
}

