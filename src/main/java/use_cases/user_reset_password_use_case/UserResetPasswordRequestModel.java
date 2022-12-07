package use_cases.user_reset_password_use_case;

public class UserResetPasswordRequestModel {

    final String reNewPassword;
    final String username;
    final String password;
    final boolean whether_org;
    final String newPassword;

    /** A request model sent the interactor to reset the new password.
     *
     * @param username The username of the user
     * @param password The current password of the user
     * @param whether_org Boolean showing whether the user is an organizer.
     * @param newPassword The new password of the user
     * @param reNewPassword The second input password of the user
     */
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isWhether_org() {
        return whether_org;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
