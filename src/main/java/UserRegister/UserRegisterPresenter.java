package UserRegister;


import UserRegisterScreen.*;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {
    public void prepareFailView(UserRegisterResponseModel failureresponse){
        String name = failureresponse.getName();
        String password = failureresponse.getPassword();
        String message = failureresponse.getMessage();
        new FailureViewModel(message);
    }

    public void prepareSuccessView(UserRegisterResponseModel successresponse){
        String name = successresponse.getName();
        String password = successresponse.getPassword();
        String message = successresponse.getMessage();
        new SuccessViewModel(message);
    }
}
