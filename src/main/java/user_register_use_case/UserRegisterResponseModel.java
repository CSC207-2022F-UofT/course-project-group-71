package user_register_use_case;

/** The response model sent back to the page.
 *  Containing the username and the message.
 */
public class UserRegisterResponseModel {
    private String username;
    private String message;

    public UserRegisterResponseModel(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
