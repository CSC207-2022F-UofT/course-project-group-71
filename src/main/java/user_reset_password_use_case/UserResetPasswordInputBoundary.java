package user_reset_password_use_case;

import java.sql.SQLException;

public interface UserResetPasswordInputBoundary {
    UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
