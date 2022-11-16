package screens.org_account;

import user_reset_password_use_case.UserResetPasswordPresenter;
import user_reset_password_use_case.UserResetPasswordResponseModel;
import screens.ShowMessageView;

public class UserResetPasswordResponseFormatter implements UserResetPasswordPresenter {
    public UserResetPasswordResponseModel prepareView(String message) {
        throw new ShowMessageView(message);
    }
}
