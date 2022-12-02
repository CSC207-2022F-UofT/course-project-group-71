package use_cases.user_login_use_case;

public class UserLoginRequestModel {

    String isParticipant;
    String isOrganization;
    String username;
    String password;

    public UserLoginRequestModel(String isParticipant, String isOrganization, String username, String password) {
        this.isParticipant = isParticipant;
        this.isOrganization = isOrganization;
        this.username = username;
        this.password = password;
    }

    public String getUserType() {
        if (isParticipant.equals("P")) { return isParticipant; }
        else if (isOrganization.equals("O")) { return isOrganization; }
        else { return "N/A"; }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
