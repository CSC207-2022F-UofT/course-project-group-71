package screens.org_account;

import org_reset_password_use_case.OrgResetPasswordPresenter;
import org_reset_password_use_case.OrgResetPasswordResponseModel;
import screens.ShowMessageView;

public class OrgResetPasswordResponseFormatter implements OrgResetPasswordPresenter {
    public OrgResetPasswordResponseModel prepareView(String message) {
        throw new ShowMessageView(message);
    }
}
