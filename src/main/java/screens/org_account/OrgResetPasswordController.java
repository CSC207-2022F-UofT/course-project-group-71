package screens.org_account;

import user_reset_password_use_case.*;

public class OrgResetPasswordController {
    final UserResetPasswordInputBoundary userInput;

    public OrgResetPasswordController(UserResetPasswordInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    UserResetPasswordResponseModel resetPassword(String username, String password, String newPassword, String reNewPassword) {
        UserResetPasswordRequestModel requestModel = new UserResetPasswordRequestModel(username, password, true, newPassword, reNewPassword);

        return userInput.resetPassword(requestModel);
    }
}
