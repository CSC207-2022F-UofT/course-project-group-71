package user_login_use_case;

import database.ParDsGateway;
import database.OrgDsGateway;

public class UserLoginInteractor implements UserLoginInputBoundary {

    final UserLoginPresenter userLoginPresenter;
    final ParDsGateway parDsGateway;
    final ParHomePresenter parHomePresenter;
    final OrgDsGateway orgDsGateway;
    final OrgHomePresenter orgHomePresenter;

    /**This is the construct method of UserRegisterInteractor.
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param parDsGateway The database gateway of the participants
     * @param orgDsGateway The database gateway of the organizers
     * @param userLoginPresenter The presenter used to show fail messages of login
     * @param parHomePresenter The presenter used to show the home page of the participant
     * @param orgHomePresenter The presenter used to show the home page of the participant
     */
    public UserLoginInteractor(UserLoginPresenter userLoginPresenter, ParDsGateway parDsGateway,
                               ParHomePresenter parHomePresenter, OrgDsGateway orgDsGateway,
                               OrgHomePresenter orgHomePresenter) {
        this.userLoginPresenter = userLoginPresenter;
        this.parDsGateway = parDsGateway;
        this.parHomePresenter = parHomePresenter;
        this.orgDsGateway = orgDsGateway;
        this.orgHomePresenter = orgHomePresenter;
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
    public UserLoginResponseModel login(UserLoginRequestModel requestModel) {
        if (requestModel.getUserType().equals("P")) {
            String username = requestModel.getUsername();
            if (!parDsGateway.checkIfUsernameExist(username)) {
                return userLoginPresenter.prepareFailView("Participant does not exist.");
            } else if (!parDsGateway.getPassword(username).equals(requestModel.getPassword())) {
                return userLoginPresenter.prepareFailView("Password doesn't match.");
            }

            UserLoginResponseModel accountResponseModel = new UserLoginResponseModel(username);
            return parHomePresenter.prepareHomePageView(accountResponseModel);
        }
        else if (requestModel.getUserType().equals("O")) {
            String username = requestModel.getUsername();
            if (!orgDsGateway.checkIfUsernameExist(username)) {
                return userLoginPresenter.prepareFailView("Organization does not exist.");
            } else if (!orgDsGateway.getPassword(username).equals(requestModel.getPassword())) {
                return userLoginPresenter.prepareFailView("Password doesn't match.");
            }

            UserLoginResponseModel accountResponseModel = new UserLoginResponseModel(username);
            return orgHomePresenter.prepareHomePageView(accountResponseModel);
        }
        else {
            return userLoginPresenter.prepareFailView("Please select your account type.");
        }
    }
}
