package screens;

import user_register_use_case.UserRegisterInputBoundary;
import user_register_use_case.UserRegisterRequestModel;
import user_register_use_case.UserRegisterResponseModel;

import java.sql.SQLException;

public class UserRegisterController {
    final UserRegisterInputBoundary interactor;

    /**This is constructor method of The UserRegisterController that takes an input interactor and stored in.
     *
     * @param potential_interactor The interactor sent to the controller
     */
    public UserRegisterController(UserRegisterInputBoundary potential_interactor) {
        this.interactor = potential_interactor;

    }

    /**The method is used to create a user account, it will call requestmodel and interactor and sent
     * them information for user creation.
     *
     * @param isParticipant String showing the user choose to create a participant
     * @param isOrganization String showing the user choose to create an organization
     * @param username The username of the user registration
     * @param password The password of the user registration
     * @param retypePassword The second input password of the user registration
     * @return The response model showing whether creation is successful
     */
    public UserRegisterResponseModel create(String isParticipant, String isOrganization, String username, String password, String retypePassword) throws SQLException, ClassNotFoundException {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                isParticipant, isOrganization, username, password, retypePassword);

        return interactor.create(requestModel);
    }
}
