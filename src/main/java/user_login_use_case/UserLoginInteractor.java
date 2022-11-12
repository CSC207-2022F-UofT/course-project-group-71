package user_login_use_case;

import java.time.LocalDateTime;

public class UserLoginInteractor implements UserLoginInputBoundary {

    final UserLoginPresenter userLoginPresenter;
    final ParDsGateway parDsGateway;
    final ParHomePresenter parHomePresenter;
    final OrgDsGateway orgDsGateway;
    final OrgHomePresenter orgHomePresenter;

    public UserLoginInteractor(ParDsGateway parDsGateway, ParHomePresenter parHomePresenter) {
        this.parDsGateway = parDsGateway;
        this.parHomePresenter = parHomePresenter;
    }

    public UserLoginInteractor(OrgDsGateway orgDsGateway, OrgHomePresenter orgHomePresenter) {
        this.orgDsGateway = orgDsGateway;
        this.orgHomePresenter = orgHomePresenter;
    }
    
    public UserLoginResponseModel login(UserLoginRequestModel requestModel) {
        if (requestModel.getUserType().equals("P")) {
            if (!parDsGateway.existsByUsername(requestModel.getName())) {
                return userLoginPresenter.prepareFailView("Participant does not exist.");
            } else if (!parDsGateway.checkPassword(requestModel.getRepeatPassword())) {
                return userLoginPresenter.prepareFailView("Password doesn't match.");
            }

            ParPageResponseModel accountResponseModel = new ParPageResponseModel(requestModel.getUsername());
            return parHomePresenter.prepareHomePageView(accountResponseModel);
        }
        else if (requestModel.getUserType().equals("O")) {
            if (!orgDsGateway.existsByUsername(requestModel.getName())) {
                return userLoginPresenter.prepareFailView("Organization does not exist.");
            } else if (!orgDsGateway.checkPassword(requestModel.getRepeatPassword())) {
                return userLoginPresenter.prepareFailView("Password doesn't match.");
            }

            OrgPageResponseModel accountResponseModel = new OrgPageResponseModel(requestModel.getUsername());
            return orgHomePresenter.prepareHomePageView(accountResponseModel);
        }
        else {
            return userLoginPresenter.prepareFailView("Please select your account type.");
        }
    }
}
