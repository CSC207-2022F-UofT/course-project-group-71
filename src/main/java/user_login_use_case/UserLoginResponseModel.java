package user_login_use_case;

import java.util.ArrayList;

public class UserLoginResponseModel {
    String username;
    ArrayList<String> notifications;

    public UserLoginResponseModel(String username) {
        this.username = username;
    }

    public UserLoginResponseModel(String username, ArrayList<String> notifications) {
        this.username = username;
        this.notifications = notifications;
    }
    public String getUsername() {
        return username;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }
}
