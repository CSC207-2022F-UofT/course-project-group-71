package user_register_use_case;

public class UserRegisterResponseModel {
    private String username;

    /**This is the construct method of UserRegisterResponseModel, it took a username and store it as instance.
     *
     * @param username The username of the registering user
     */
    public UserRegisterResponseModel(String username){
        this.username = username;
    }

    /**This is a method to get the username entered by the user.
     *
     * @return The username used for registering
     */
    public String getUsername() {
        return username;
    }

    /**This is a method to change the username entered by the user.
     *
     * @param username THe username used for registering
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
