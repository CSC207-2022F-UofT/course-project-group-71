package screens.org_account;

import user_reset_password_use_case.*;

public class OrgResetPasswordController {
    final UserResetPasswordInputBoundary userInput;

    public OrgResetPasswordController(UserResetPasswordInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    UserResetPasswordResponseModel resetPassword( String orgUsername, String oldPassword, String newPassword, String retypeNewPassword) {
        UserResetPasswordRequestModel requestModel = new UserResetPasswordRequestModel(orgUsername, oldPassword, newPassword, retypeNewPassword);

        return userInput.resetPassword(requestModel);
    }
}
