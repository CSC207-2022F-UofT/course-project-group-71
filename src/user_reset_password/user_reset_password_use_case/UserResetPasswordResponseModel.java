package user_reset_password_use_case;

public class UserResetPasswordResponseModel {
    String message;

    public UserResetPasswordResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String massage) {
        this.message = massage;
    }
}
