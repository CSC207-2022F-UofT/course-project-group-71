package user_login_use_case;

public class UserLoginResponseModel {
    String username;
    String notification;

    public UserLoginResponseModel(String username) {
        this.username = username;
    }

    public UserLoginResponseModel(String username, String notification) {
        this.username = username;
        this.notification = notification;
    }
    public String getUsername() {
        return username;
    }

    public String getNotification() {
        return notification;
    }
}
