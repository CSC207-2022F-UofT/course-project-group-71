package use_cases.user_login_use_case;

public interface UserLoginInputBoundary {
    //it will throw ClassNotFoundException when JDBC or MySQL class is not found.
    UserLoginResponseModel login(UserLoginRequestModel requestModel) throws ClassNotFoundException;
}