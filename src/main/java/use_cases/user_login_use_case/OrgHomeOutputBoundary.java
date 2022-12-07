package use_cases.user_login_use_case;

public interface OrgHomeOutputBoundary {
    UserLoginResponseModel prepareHomePageView(UserLoginResponseModel organization);
}