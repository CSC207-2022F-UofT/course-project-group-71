package user_reset_password_use_case;

public class UserResetPasswordRequestModel {

    private String parUsername;
    private String orgUsername;
    private String oldPassword;
    private String newPassword;
    private String retypeNewPassword;

    public UserResetPasswordRequestModel(String parUsername, String orgUsername, String oldPassword, String newPassword) {
        this.parUsername = parUsername;
        this.orgUsername = orgUsername;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.retypeNewPassword = retypeNewPassword;
    }

    public String getUsername() {
        return parUsername;
    }

    public void setUsername(String parUsername) {
        this.parUsername = parUsername;
    }

    public String getOrgUsername() {return orgUsername;}

    public void setOrgUsername(String orgUsername) {this.orgUsername = orgUsername;}

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRetypeNewPassword() {
        return retypeNewPassword;
    }

    public void setRetypeNewPassword(String retypeNewPassword) {
        this.retypeNewPassword = retypeNewPassword;
    }
}
