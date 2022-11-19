package user_reset_password_use_case;


public interface UserResetPasswordOutputBoundary {
    UserResetPasswordResponseModel prepareFailureView(String message);
    UserResetPasswordResponseModel prepareSuccessView(UserResetPasswordResponseModel responseModel);
}
