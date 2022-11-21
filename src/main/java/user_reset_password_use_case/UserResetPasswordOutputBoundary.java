package user_reset_password_use_case;


public interface UserResetPasswordOutputBoundary {
    /** A method used to show one of the three views to the user about whether reset successfully
     *
     * @param message A String containing information about success and the reason of failure.
     * @return A response model showing if the resetname is success
     */
    UserResetPasswordResponseModel prepareFailureView(String message);
    UserResetPasswordResponseModel prepareSuccessView(UserResetPasswordResponseModel responseModel);
}
