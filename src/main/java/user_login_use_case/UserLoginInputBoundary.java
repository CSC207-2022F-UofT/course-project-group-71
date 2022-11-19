package user_login_use_case;

import java.sql.SQLException;

public interface UserLoginInputBoundary {
    UserLoginResponseModel login(UserLoginRequestModel requestModel) throws SQLException, ClassNotFoundException;
}