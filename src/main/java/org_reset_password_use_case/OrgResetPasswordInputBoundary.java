package org_reset_password_use_case;

import org_delete_event_use_case.OrgDeleteEventResponseModel;
import screens.org_account.OrgResetPasswordController;

public interface OrgResetPasswordInputBoundary {
    OrgResetPasswordResponseModel resetPassword(OrgResetPasswordRequestModel  requestModel);
}
