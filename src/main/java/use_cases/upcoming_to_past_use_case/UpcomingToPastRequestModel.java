package use_cases.upcoming_to_past_use_case;

public class UpcomingToPastRequestModel {

    final String userType;
    final String username;
    public UpcomingToPastRequestModel(String userType, String username) {
        this.userType = userType;
        this.username = username;
    }

    public String getUserType() {return userType;}
    public String getUsername() {
        return username;
    }
}
