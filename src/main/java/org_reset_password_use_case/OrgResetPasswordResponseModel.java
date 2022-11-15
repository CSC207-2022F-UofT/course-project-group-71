package org_reset_password_use_case;

import java.util.ArrayList;

public class OrgResetPasswordResponseModel {
    private String message;

    public OrgResetPasswordResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String massage) {
        this.message = massage;
    }
}
