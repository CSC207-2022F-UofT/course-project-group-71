package user_register_use_case;


import UserRegisterScreen.RegisterFailureViewModel;
import UserRegisterScreen.RegisterSuccessViewModel;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {
    public void prepareFailView(UserRegisterResponseModel failureresponse){
        String name = failureresponse.getName();
        String password = failureresponse.getPassword();
        String message = failureresponse.getMessage();
        RegisterFailureViewModel f = new RegisterFailureViewModel(message);
        f.GeneratePage();
    }

    public void prepareSuccessView(UserRegisterResponseModel successresponse){
        String name = successresponse.getName();
        String password = successresponse.getPassword();
        String message = successresponse.getMessage();
        RegisterSuccessViewModel f = new RegisterSuccessViewModel(message);
        f.GeneratePage();
    }
}
