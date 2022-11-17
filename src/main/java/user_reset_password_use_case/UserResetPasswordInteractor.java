package user_reset_password_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;
import user_login_use_case.*;

public class UserResetPasswordInteractor implements UserResetPasswordInputBoundary {
    final UserResetPasswordPresenter userResetPasswordPresenter;
    final OrgDsGateway orgDsGateway;
    final OrgHomePresenter orgHomePresenter;
    private ParDsGateway parDsGateway;

    public UserResetPasswordInteractor(UserResetPasswordPresenter userResetPasswordPresenter, OrgDsGateway orgDsGateway, ParDsGateway parDsGateway,
                                       OrgHomePresenter orgHomePresenter) {
        this.userResetPasswordPresenter = userResetPasswordPresenter;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
        this.orgHomePresenter = orgHomePresenter;
    }

    public UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel) {
        if (requestModel.isWhether_org()){
            //Organizer
            if (requestModel.getPassword().equals(orgDsGateway.getPassword(requestModel.getUsername()))){
                return userResetPasswordPresenter.prepareView("Old password is not correct.");
            }
            else {
                if (requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                    orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
                    return userResetPasswordPresenter.prepareView("Password reset successfully!");
                }
                else {
                    return userResetPasswordPresenter.prepareView("New Passwords do not match.");
                }
            }
        }
        else {
            //Participant
            if (requestModel.getPassword().equals(parDsGateway.getPassword(requestModel.getUsername()))){
                return userResetPasswordPresenter.prepareView("Old password is not correct.");
            }
            else {
                if (requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                    parDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
                    return userResetPasswordPresenter.prepareView("Password reset successfully!");
                }
                else {
                    return userResetPasswordPresenter.prepareView("New Passwords do not match.");
                }
            }
        }


    }
}
