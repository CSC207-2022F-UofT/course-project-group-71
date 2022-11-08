package screens;

public class UserLoginFailed extends RuntimeException {
    public UserLoginFailed(String error) {
        super(error);
    }
}