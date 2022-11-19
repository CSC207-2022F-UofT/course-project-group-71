package user_reset_password_use_case;


public interface UserResetPasswordPresenter {
    public UserResetPasswordResponseModel prepareFailView(String message);

    public UserResetPasswordResponseModel prepareSuccessView(UserResetPasswordResponseModel responseModel);
}
