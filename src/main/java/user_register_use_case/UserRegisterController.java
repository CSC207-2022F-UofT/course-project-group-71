package user_register_use_case;

public class UserRegisterController {
    final UserRegisterInputBoundary interactor;

    public UserRegisterController(UserRegisterInputBoundary potential_interactor) {
        this.interactor = potential_interactor;

    }

    public UserRegisterResponseModel create(String isParticipant, String isOrganization, String username, String password, String retypePassword) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                isParticipant, isOrganization, username, password, retypePassword);

        return interactor.create(requestModel);
    }
}
