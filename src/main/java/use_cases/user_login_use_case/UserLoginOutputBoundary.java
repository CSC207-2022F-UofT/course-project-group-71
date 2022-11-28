package use_cases.user_login_use_case;

public interface UserLoginOutputBoundary {
    UserLoginResponseModel prepareFailView(String error);
}