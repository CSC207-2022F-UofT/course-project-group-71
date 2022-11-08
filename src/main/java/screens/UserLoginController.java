package screens;

import user_login_use_case.UserLoginResponseModel;
import user_login_use_case.UserLoginInputBoundary;
import user_login_use_case.UserLoginRequestModel;

public class UserLoginController {
    final UserLoginInputBoundary userInput;

    public UserLoginController(UserLoginInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    UserLoginResponseModel login(String userType, String username, String password) {
        UserLoginRequestModel requestModel = new UserLoginRequestModel(
                userType, username, password);

        return userInput.login(requestModel);
    }
}
