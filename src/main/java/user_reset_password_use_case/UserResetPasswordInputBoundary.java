package user_reset_password_use_case;

public interface UserResetPasswordInputBoundary {
    UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel);
}
