package org_reset_password_use_case;

public class OrgResetPasswordRequestModel {

    private String username;
    private String oldPassword;
    private String newPassword;
    private String retypeNewPassword;

    public OrgResetPasswordRequestModel(String username, String oldPassword, String newPassword, String retypeNewPassword) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.retypeNewPassword = retypeNewPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getRetypeNewPassword() {
        return retypeNewPassword;
    }
}
