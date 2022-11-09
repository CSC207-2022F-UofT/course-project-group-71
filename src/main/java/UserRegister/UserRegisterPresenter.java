package UserRegister;


import UserRegisterScreen.FailureViewModel;
import UserRegisterScreen.SuccessViewModel;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {
    public void prepareFailView(UserRegisterResponseModel failureresponse){
        String name = failureresponse.getName();
        String password = failureresponse.getPassword();
        String message = failureresponse.getMessage();
        FailureViewModel f = new FailureViewModel(message);
        f.GeneratePage();
    }

    public void prepareSuccessView(UserRegisterResponseModel successresponse){
        String name = successresponse.getName();
        String password = successresponse.getPassword();
        String message = successresponse.getMessage();
        SuccessViewModel f = new SuccessViewModel(message);
        f.GeneratePage();
    }
}
