package use_cases.user_login_use_case;

public interface ParHomeOutputBoundary {
    UserLoginResponseModel prepareHomePageView(UserLoginResponseModel participant);
}