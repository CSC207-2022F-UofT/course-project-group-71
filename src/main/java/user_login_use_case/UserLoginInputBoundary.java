package user_login_use_case;

public interface UserLoginInputBoundary {
    UserLoginResponseModel login(UserLoginRequestModel requestModel);
}
