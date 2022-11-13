package user_register_use_case;

public class UserRegisterResponseModel {
    private String message;
    public UserRegisterResponseModel(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
