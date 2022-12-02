package controller_presenter_view.screens.org_account.org_reset_password;

import use_cases.user_reset_password_use_case.UserResetPasswordInputBoundary;
import use_cases.user_reset_password_use_case.UserResetPasswordRequestModel;
import use_cases.user_reset_password_use_case.UserResetPasswordResponseModel;

public class OrgResetPasswordController {
    final UserResetPasswordInputBoundary userInput;

    public OrgResetPasswordController(UserResetPasswordInputBoundary accountGateway) {
        //Store the interactor as instance
        this.userInput = accountGateway;
    }

    public UserResetPasswordResponseModel resetPassword(String username, String password, String newPassword, String reNewPassword) throws ClassNotFoundException {
        UserResetPasswordRequestModel requestModel = new UserResetPasswordRequestModel(username, password, true, newPassword, reNewPassword);
        //Send request model to interactor
        return userInput.resetPassword(requestModel);
    }
}
