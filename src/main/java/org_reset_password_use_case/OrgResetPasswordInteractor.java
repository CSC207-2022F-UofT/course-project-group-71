package org_reset_password_use_case;

import database.OrgDsGateway;
import user_login_use_case.*;

public class OrgResetPasswordInteractor implements OrgResetPasswordInputBoundary{
    final OrgResetPasswordPresenter orgResetPasswordPresenter;
    final OrgDsGateway orgDsGateway;
    final OrgHomePresenter orgHomePresenter;

    public OrgResetPasswordInteractor(OrgResetPasswordPresenter orgResetPasswordPresenter, OrgDsGateway orgDsGateway,
                               OrgHomePresenter orgHomePresenter) {
        this.orgResetPasswordPresenter = orgResetPasswordPresenter;
        this.orgDsGateway = orgDsGateway;
        this.orgHomePresenter = orgHomePresenter;
    }

    public OrgResetPasswordResponseModel resetPassword(OrgResetPasswordRequestModel requestModel) {

        if (requestModel.getOldPassword().equals(orgDsGateway.getPassword(requestModel.getUsername()))){
            return orgResetPasswordPresenter.prepareView("Old password is not correct.");
        }
        else {
            if (requestModel.getNewPassword().equals(requestModel.getRetypeNewPassword())) {
                orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
                return orgResetPasswordPresenter.prepareView("Password reset successfully!");
            }
            else {
                return orgResetPasswordPresenter.prepareView("New Passwords do not match.");
            }
        }
    }
}
