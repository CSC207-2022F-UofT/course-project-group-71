package screens.org_account;

import user_reset_password_use_case.UserResetPasswordOutputBoundary;
import user_reset_password_use_case.UserResetPasswordResponseModel;
import screens.ShowMessageView;

public class OrgResetPasswordPresenter implements UserResetPasswordOutputBoundary {
    public UserResetPasswordResponseModel prepareView(String message) {
        throw new ShowMessageView(message);
    }
}
