package use_cases.user_login_use_case;

public class UserLoginResponseModel {
    final String username;

    public UserLoginResponseModel(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
}
