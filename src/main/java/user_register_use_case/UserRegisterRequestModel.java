package user_register_use_case;

public class UserRegisterRequestModel {

    private String isParticipant;

    private  String isOrganization;

    private String name;
    private String password;
    private String re_password;

    public UserRegisterRequestModel(String isParticipant, String isOrganization, String name, String password, String re_password){
        this.isParticipant = isParticipant;
        this.isOrganization = isOrganization;
        this.name = name;
        this.password = password;
        this.re_password = re_password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRe_password() {
        return re_password;
    }

    public void setRe_password(String re_password) {
        this.re_password = re_password;
    }
    public String getUserType() {
        if (isParticipant.equals("P")) { return isParticipant; }
        else if (isOrganization.equals("O")) { return isOrganization; }
        else { return "N/A"; }
    }
}
