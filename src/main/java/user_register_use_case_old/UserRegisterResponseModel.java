package user_register_use_case_old;

/** The response model sent back to the page.
 *  Containing the username and the message.
 */
public class UserRegisterResponseModel {
    private String username;
    private String message;

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

    /**This is a method to set the message sent back
     *
     * @param message The message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**This is a method to get the message sent back
     *
     * @return The message sent back
     */
    public String getMessage() {
        return message;
    }
}
