package upcoming_to_past_use_case;

public class UpcomingToPastRequestModel {

    private String userType;
    private String username;
    public UpcomingToPastRequestModel(String userType, String username) {
        this.userType = userType;
        this.username = username;
    }

    public String getUserType() {return userType;}
    public String getUsername() {
        return username;
    }
}
