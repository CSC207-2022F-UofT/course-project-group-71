package user_reset_password_use_case;

public class UserResetPasswordResponseModel {
    private String message;

    /** This is a construct method of UserRestPasswordResponseModel, it will judge which conditions and send to the spercific
     * message
     * @param message the message that show if reset name successfully and the reason of faliure.
     */

    public UserResetPasswordResponseModel(String message) {
        this.message = message;
    }

    /** This is a method that get the correct message to show that status of reseting the password
     *
     * @return the message that show if reset name successfully and the reason of faliure.
     */

    public String getMessage() {
        return message;
    }
    public void setMessage(String massage) {
        this.message = massage;
    }
}
