package UserRegister;

public class UserRegisterController {
    final UserRegisterInputBoundary interactor;
    public UserRegisterController(UserRegisterInputBoundary potential_interactor){
        this.interactor = potential_interactor;

    }

    void create(String username, String password, String re_password, boolean whether_org){
        UserRegisterRequestModel requestmodel = new UserRegisterRequestModel(username, password, re_password, whether_org);

        interactor.create(requestmodel);
    }

}
