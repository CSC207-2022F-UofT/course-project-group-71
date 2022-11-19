package screens.par_account;

import user_reset_password_use_case.UserResetPasswordInputBoundary;
import user_reset_password_use_case.UserResetPasswordRequestModel;
import user_reset_password_use_case.UserResetPasswordResponseModel;

import java.sql.SQLException;

public class ParResetPasswordController {
    final UserResetPasswordInputBoundary userInput;

    public ParResetPasswordController(UserResetPasswordInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public UserResetPasswordResponseModel resetPassword(String username, String password, String newPassword, String reNewPassword) throws SQLException, ClassNotFoundException {
        UserResetPasswordRequestModel requestModel = new UserResetPasswordRequestModel(username, password, false, newPassword, reNewPassword);
        return userInput.resetPassword(requestModel);
    }
}

