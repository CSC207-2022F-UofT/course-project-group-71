package user_reset_password_use_case;

import screens.ShowMessageView;

public class UserResetPasswordFormatter implements UserResetPasswordPresenter{
    /**This is a method used to prepare one of three view to user.
     *
     * @param message A String containing information about success or how to fail
     * @return Response model to show some view
     */
    public UserResetPasswordResponseModel prepareView(String message) {
        throw new ShowMessageView(message);
    }
}
