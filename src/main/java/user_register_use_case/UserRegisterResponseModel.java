package user_register_use_case;

public class UserRegisterResponseModel {
    private String username;
    public UserRegisterResponseModel(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
