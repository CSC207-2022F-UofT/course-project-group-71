package use_cases.user_login_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

public class UserLoginInteractor implements UserLoginInputBoundary {

    UserLoginOutputBoundary userLoginOutputBoundary;
    ParDsGateway parDsGateway;
    ParHomeOutputBoundary parHomeOutputBoundary;
    OrgDsGateway orgDsGateway;
    OrgHomeOutputBoundary orgHomeOutputBoundary;

    /**Constructor
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

    /**Do checks to user inputs, if fail give hints, if pass direct user to the corresponding home page according to the
     * user type.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the user creation is successful
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public UserLoginResponseModel login(UserLoginRequestModel requestModel) throws ClassNotFoundException {
        if (requestModel.getUserType().equals("P")) {
            String username = requestModel.getUsername();
            System.out.println("Fuck");
            if (!parDsGateway.checkIfUsernameExist(username)) {
                System.out.println("e");
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
