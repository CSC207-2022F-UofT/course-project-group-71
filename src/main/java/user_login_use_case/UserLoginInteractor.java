package user_login_use_case;

import database.ParDsGateway;
import database.OrgDsGateway;

public class UserLoginInteractor implements UserLoginInputBoundary {

    private UserLoginPresenter userLoginPresenter;
    private ParDsGateway parDsGateway;
    private ParHomePresenter parHomePresenter;
    private OrgDsGateway orgDsGateway;
    private OrgHomePresenter orgHomePresenter;

    public UserLoginInteractor(UserLoginPresenter userLoginPresenter, ParDsGateway parDsGateway,
                               ParHomePresenter parHomePresenter, OrgDsGateway orgDsGateway,
                               OrgHomePresenter orgHomePresenter) {
        this.userLoginPresenter = userLoginPresenter;
        this.parDsGateway = parDsGateway;
        this.parHomePresenter = parHomePresenter;
        this.orgDsGateway = orgDsGateway;
        this.orgHomePresenter = orgHomePresenter;
    }
    
    public UserLoginResponseModel login(UserLoginRequestModel requestModel) {
        if (requestModel.getUserType().equals("P")) {
            String username = requestModel.getUsername();
            if (!parDsGateway.checkIfUsernameExist(username)) {
                return userLoginPresenter.prepareFailView("Participant does not exist.");
            } else if (!parDsGateway.getPassword(username).equals(requestModel.getPassword())) {
                return userLoginPresenter.prepareFailView("Password doesn't match.");
            }

            UserLoginResponseModel accountResponseModel = new UserLoginResponseModel(username,
                    parDsGateway.getNotifications(username));
            parDsGateway.clearNotifications(username);
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
