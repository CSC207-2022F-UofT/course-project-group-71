package screens;

import user_register_use_case.UserRegisterInputBoundary;
import user_register_use_case.UserRegisterRequestModel;
import user_register_use_case.UserRegisterResponseModel;

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
