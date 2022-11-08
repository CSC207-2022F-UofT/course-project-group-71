package user_login_use_case;

public class UserLoginRequestModel {

    private boolean isParticipant;
    private boolean isOrganization;
    private String username;
    private String password;

    public UserLoginRequestModel(boolean isParticipant, boolean isOrganization, String username, String password) {
        this.isParticipant = isParticipant;
        this.isOrganization = isOrganization;
        this.username = username;
        this.password = password;
    }

    public String getUserType() {
        if (isParticipant) {
            return "P";
        }
        if (isOrganization) {
            return "O";
        }
        return "N/A";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
