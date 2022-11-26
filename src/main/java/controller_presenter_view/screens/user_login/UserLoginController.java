package controller_presenter_view.screens.user_login;

import user_login_use_case.UserLoginResponseModel;
import user_login_use_case.UserLoginInputBoundary;
import user_login_use_case.UserLoginRequestModel;

import java.sql.SQLException;

public class UserLoginController {
    final UserLoginInputBoundary userInput;

    public UserLoginController(UserLoginInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public UserLoginResponseModel login(String isParticipant, String isOrganization, String username, String password) throws SQLException, ClassNotFoundException {
        UserLoginRequestModel requestModel = new UserLoginRequestModel(
                isParticipant, isOrganization, username, password);

        return userInput.login(requestModel);
    }
}
