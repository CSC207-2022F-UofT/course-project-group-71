package screens.org_account;

import org_reset_password_use_case.*;

public class OrgResetPasswordController {
    final OrgResetPasswordInputBoundary userInput;

    public OrgResetPasswordController(OrgResetPasswordInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    OrgResetPasswordResponseModel resetPassword(String username, String oldPassword, String newPassword, String retypeNewPassword) {
        OrgResetPasswordRequestModel requestModel = new OrgResetPasswordRequestModel(username, oldPassword, newPassword, retypeNewPassword);

        return userInput.resetPassword(requestModel);
    }
}
