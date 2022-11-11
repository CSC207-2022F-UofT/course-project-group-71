package screens;

public class UserLoginFailedView extends RuntimeException {
    public UserLoginFailedView(String error) {
        super(error);
    }
}