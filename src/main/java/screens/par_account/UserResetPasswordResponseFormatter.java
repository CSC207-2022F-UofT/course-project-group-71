package screens.par_account;

import screens.ShowMessageView;
import user_reset_password_use_case.UserResetPasswordResponseModel;

public class UserResetPasswordResponseFormatter {
    public UserResetPasswordResponseModel prepareView(String message) {
        throw new ShowMessageView(message);
}}
