package org_reset_password_use_case;

import database.OrgDsGateway;
import user_login_use_case.*;

public class OrgResetPasswordInteractor implements OrgResetPasswordInputBoundary{
    private OrgResetPasswordPresenter orgResetPasswordPresenter;
    private OrgDsGateway orgDsGateway;
    private OrgHomePresenter orgHomePresenter;

    public OrgResetPasswordInteractor(OrgResetPasswordPresenter orgResetPasswordPresenter, OrgDsGateway orgDsGateway,
                               OrgHomePresenter orgHomePresenter) {
        this.orgResetPasswordPresenter = orgResetPasswordPresenter;
        this.orgDsGateway = orgDsGateway;
        this.orgHomePresenter = orgHomePresenter;
    }

    public OrgResetPasswordResponseModel resetPassword(OrgResetPasswordRequestModel requestModel) {
        orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getPassword());
        return orgResetPasswordPresenter.prepareSuccessView("Password reset successfully");
    }
}
