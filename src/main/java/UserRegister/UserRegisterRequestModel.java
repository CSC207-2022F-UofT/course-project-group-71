package UserRegister;

public class UserRegisterRequestModel {

    private String name;
    private String password;
    private String re_password;

    //If organizer, set to true, if participant, set to false
    private boolean whether_org;

    public UserRegisterRequestModel(String name, String password, String re_password, boolean whether_org){
        this.name = name;
        this.password = password;
        this.re_password = re_password;
        this.whether_org = whether_org;
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

    public boolean isWhether_org() {
        return whether_org;
    }

    public void setWhether_org(boolean whether_org) {
        this.whether_org = whether_org;
    }

}
