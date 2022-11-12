package user_register_use_case;

public class UserRegisterResponseModel {
    private String name;
    private String password;
    private String message;
    public UserRegisterResponseModel(String name, String password, String message){
        this.name = name;
        this.password = password;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
