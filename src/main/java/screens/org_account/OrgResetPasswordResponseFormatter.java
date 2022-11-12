package screens.org_account;

import org_reset_password_use_case.OrgResetPasswordResponseModel;
import screens.ShowMessageView;

public class OrgResetPasswordResponseFormatter {
    public OrgResetPasswordResponseModel prepareSuccessView(String message) {
        throw new ShowMessageView(message);
    }
}
