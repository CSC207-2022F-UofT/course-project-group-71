package screens;

public class UserLoginController {
    final UserLoginInputBoundary userInput;

    public UserLoginController(UserLoginInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    UserLoginResponseModel create(boolean isParticipant, boolean isOrganization, String username, String password) {
        UserLoginRequestModel requestModel = new UserLoginRequestModel(
                isParticipant, isOrganization, username, password);

        return userInput.login(requestModel);
    }
}
