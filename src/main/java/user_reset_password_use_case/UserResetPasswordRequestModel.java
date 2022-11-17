package user_reset_password_use_case;

public class UserResetPasswordRequestModel {

    private String reNewPassword;
    private String username;
    private String password;
    private boolean whether_org;
    private String newPassword;

    public UserResetPasswordRequestModel(String username, String password, boolean whether_org, String newPassword, String reNewPassword) {
        this.username = username;
        this.password = password;
        this.whether_org = whether_org;
        this.newPassword = newPassword;
        this.reNewPassword = reNewPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isWhether_org() {
        return whether_org;
    }

    public void setWhether_org(boolean whether_org) {
        this.whether_org = whether_org;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
