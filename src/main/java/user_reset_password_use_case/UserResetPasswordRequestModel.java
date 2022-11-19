package user_reset_password_use_case;

public class UserResetPasswordRequestModel {

    private String reNewPassword;
    private String username;
    private String password;
    private boolean whether_org;
    private String newPassword;

    /** A request model sent the interactor to reset the new password.
     *
     * @param username The username of the user
     * @param password The currentlly password of the user
     * @param whether_org Bollean showing whether the user is an orgnizer.
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

    /**A method to get the new password of user from the request model
     *
     * @return New password of the user
     */

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    /** A method to get the name of the user from the request model.
     *
     * @return name of the user
     */

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
