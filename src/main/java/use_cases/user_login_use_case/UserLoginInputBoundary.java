package use_cases.user_login_use_case;

public interface UserLoginInputBoundary {
    UserLoginResponseModel login(UserLoginRequestModel requestModel) throws ClassNotFoundException;
}