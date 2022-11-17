package user_reset_password_use_case;

import screens.ShowMessageView;

public class UserResetPasswordFormatter implements UserResetPasswordPresenter{
    /**
     *
     * @param message
     * @return
     */
    public UserResetPasswordResponseModel prepareView(String message) {
        throw new ShowMessageView(message);
    }
}
