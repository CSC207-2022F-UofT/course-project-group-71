package user_reset_password_use_case;

import database.OrgDsGateway;
import user_login_use_case.*;

public class UserResetPasswordInteractor implements UserResetPasswordInputBoundary {
    final UserResetPasswordPresenter userResetPasswordPresenter;
    final OrgDsGateway orgDsGateway;
    final OrgHomePresenter orgHomePresenter;

    public UserResetPasswordInteractor(UserResetPasswordPresenter userResetPasswordPresenter, OrgDsGateway orgDsGateway,
                                       OrgHomePresenter orgHomePresenter) {
        this.userResetPasswordPresenter = userResetPasswordPresenter;
        this.orgDsGateway = orgDsGateway;
        this.orgHomePresenter = orgHomePresenter;
    }

    public UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel) {

        if (requestModel.getOldPassword().equals(orgDsGateway.getPassword(requestModel.getUsername()))){
            return userResetPasswordPresenter.prepareView("Old password is not correct.");
        }
        else {
            if (requestModel.getNewPassword().equals(requestModel.getRetypeNewPassword())) {
                orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
                return userResetPasswordPresenter.prepareView("Password reset successfully!");
            }
            else {
                return userResetPasswordPresenter.prepareView("New Passwords do not match.");
            }
        }
    }
}
