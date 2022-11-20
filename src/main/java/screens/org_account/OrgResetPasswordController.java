package screens.org_account;

import user_reset_password_use_case.*;

import java.sql.SQLException;

public class OrgResetPasswordController {
    final UserResetPasswordInputBoundary userInput;

    public OrgResetPasswordController(UserResetPasswordInputBoundary accountGateway) {
        //Store the interactor as instance
        this.userInput = accountGateway;
    }

    public UserResetPasswordResponseModel resetPassword(String username, String password, String newPassword, String reNewPassword) throws SQLException, ClassNotFoundException {
        UserResetPasswordRequestModel requestModel = new UserResetPasswordRequestModel(username, password, true, newPassword, reNewPassword);
        //Send request model to interactor
        return userInput.resetPassword(requestModel);
    }
}
