package use_cases.user_login_use_case;

public interface UserLoginInputBoundary {
    //it will throws ClassNotFoundException when JDBC or MySQL class is not found.
    UserLoginResponseModel login(UserLoginRequestModel requestModel) throws ClassNotFoundException;
}