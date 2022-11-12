package org_reset_password_use_case;

public class OrgResetPasswordRequestModel {

    private String username;
    private String password;

    public OrgResetPasswordRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
