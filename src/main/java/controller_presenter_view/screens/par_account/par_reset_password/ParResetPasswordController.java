package controller_presenter_view.screens.par_account.par_reset_password;

import use_cases.user_reset_password_use_case.UserResetPasswordInputBoundary;
import use_cases.user_reset_password_use_case.UserResetPasswordRequestModel;
import use_cases.user_reset_password_use_case.UserResetPasswordResponseModel;

public class ParResetPasswordController {
    final UserResetPasswordInputBoundary userInput;

    /**The constructor method of the controller.
     *
     * @param accountGateway The interactor of resetting password
     */

    public ParResetPasswordController(UserResetPasswordInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    /**Generate a request model and sent it to the interactor and then return the response model sent
     * back from the interactor.
     *
     * @param username The username of the participant
     * @param password The old password of the participant
     * @param newPassword The new password of the participant
     * @param reNewPassword The second-input password of the participant
     * @return The response model returned from the interactor
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */

    public UserResetPasswordResponseModel resetPassword(String username, String password, String newPassword, String reNewPassword) throws ClassNotFoundException {
        UserResetPasswordRequestModel requestModel = new UserResetPasswordRequestModel(username, password, false, newPassword, reNewPassword);

        return userInput.resetPassword(requestModel);
    }
}

