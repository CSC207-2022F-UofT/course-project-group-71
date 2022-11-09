package UserRegister;

import UserRegister.UserRegisterOutputBoundary;
import UserRegister.UserRegisterResponseModel;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {
    public void prepareFailView(UserRegisterResponseModel failureresponse){
        String name = failureresponse.getName();
        String password = failureresponse.getPassword();
        String message = failureresponse.getMessage();
        FailureViewModel(name,password,message);
    }

    public void prepareSuccessView(UserRegisterResponseModel successresponse){
        String name = successresponse.getName();
        String password = successresponse.getPassword();
        String message = successresponse.getMessage();
        SuccessViewModel(name,password,message);
    }
}
