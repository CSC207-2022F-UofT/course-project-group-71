package screens;
import screens.ShowMessageView;
import user_register_use_case.UserRegisterPresenter;
import user_register_use_case.UserRegisterResponseModel;

public class UserRegisterResponseFormatter implements UserRegisterPresenter {
    public UserRegisterResponseModel prepareFailView(String failureresponse){
        throw new ShowMessageView(failureresponse);
    }

    public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel responseModel){
        String successresponse = responseModel.getUsername() + ", you can login now!";
        throw new ShowMessageView(successresponse);
    }
}
