package user_reset_password_use_case;


public interface UserResetPasswordOutputBoundary {
    /** A method used to show one of the three views to the user about whether reset successfully
     *
     * @param message A String containing information about the reason of failure.
     * @return A response model showing failure view
     */
    UserResetPasswordResponseModel prepareFailureView(String message);

    /**A method used to show success view to the user
     *
     * @param responseModel A response model containing information to show success view
     * @return A response model showing success view
     */
    UserResetPasswordResponseModel prepareSuccessView(UserResetPasswordResponseModel responseModel);
}
