package user_reset_password_use_case;


public interface UserResetPasswordPresenter {

    /** A method used to show one of the three views to the user about whether reset successfully
     *
     * @param message A String containing information about success and the reason of fail.
     * @return A response model showing if the resetname is success
     */
    public UserResetPasswordResponseModel prepareFailView(String message);

    public UserResetPasswordResponseModel prepareSuccessView(UserResetPasswordResponseModel responseModel);
}
