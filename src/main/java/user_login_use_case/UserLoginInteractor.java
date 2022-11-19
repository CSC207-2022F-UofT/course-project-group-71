package user_login_use_case;

import database.ParDsGateway;
import database.OrgDsGateway;

import java.sql.SQLException;

public class UserLoginInteractor implements UserLoginInputBoundary {

    final UserLoginOutputBoundary userLoginOutputBoundary;
    final ParDsGateway parDsGateway;
    final ParHomeOutputBoundary parHomeOutputBoundary;
    final OrgDsGateway orgDsGateway;
    final OrgHomeOutputBoundary orgHomeOutputBoundary;

    /**This is the construct method of UserRegisterInteractor.
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param parDsGateway The database gateway of the participants
     * @param orgDsGateway The database gateway of the organizers
     * @param userLoginOutputBoundary The presenter used to show fail messages of login
     * @param parHomeOutputBoundary The presenter used to show the home page of the participant
     * @param orgHomeOutputBoundary The presenter used to show the home page of the participant
     */
    public UserLoginInteractor(UserLoginOutputBoundary userLoginOutputBoundary, ParDsGateway parDsGateway,
                               ParHomeOutputBoundary parHomeOutputBoundary, OrgDsGateway orgDsGateway,
                               OrgHomeOutputBoundary orgHomeOutputBoundary) {
        this.userLoginOutputBoundary = userLoginOutputBoundary;
        this.parDsGateway = parDsGateway;
        this.parHomeOutputBoundary = parHomeOutputBoundary;
        this.orgDsGateway = orgDsGateway;
        this.orgHomeOutputBoundary = orgHomeOutputBoundary;
    }

    /**Use the information contained in the requestModel to check with database and respond a responseModel.
     * It first chooses which DsGateWay to use by checking which user types selected by the user.
     * Then it checks whether username exists in the database.
     * Then it check if the password matches.
     * If failed in one of the above process, return a failure response.
     * Then it direct the user to the corresponding home page.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the user creation is successful
     */
    public UserLoginResponseModel login(UserLoginRequestModel requestModel) throws SQLException, ClassNotFoundException {
        if (requestModel.getUserType().equals("P")) {
            String username = requestModel.getUsername();
            if (!parDsGateway.checkIfUsernameExist(username)) {
                return userLoginOutputBoundary.prepareFailView("Participant does not exist.");
            } else if (!parDsGateway.getPassword(username).equals(requestModel.getPassword())) {
                return userLoginOutputBoundary.prepareFailView("Password doesn't match.");
            }

            UserLoginResponseModel accountResponseModel = new UserLoginResponseModel(username);
            return parHomeOutputBoundary.prepareHomePageView(accountResponseModel);
        }
        else if (requestModel.getUserType().equals("O")) {
            String username = requestModel.getUsername();
            if (!orgDsGateway.checkIfUsernameExist(username)) {
                return userLoginOutputBoundary.prepareFailView("Organization does not exist.");
            } else if (!orgDsGateway.getPassword(username).equals(requestModel.getPassword())) {
                return userLoginOutputBoundary.prepareFailView("Password doesn't match.");
            }

            UserLoginResponseModel accountResponseModel = new UserLoginResponseModel(username);
            return orgHomeOutputBoundary.prepareHomePageView(accountResponseModel);
        }
        else {
            return userLoginOutputBoundary.prepareFailView("Please select your account type.");
        }
    }
}
