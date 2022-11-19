package user_reset_password_use_case;


public interface UserResetPasswordOutputBoundary {
    UserResetPasswordResponseModel prepareView(String message);
}
