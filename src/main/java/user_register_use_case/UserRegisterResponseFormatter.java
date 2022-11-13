package user_register_use_case;
import screens.ShowMessageView;

public class UserRegisterResponseFormatter implements UserRegisterPresenter {
    public UserRegisterResponseModel prepareFailView(String failureresponse){
        throw new ShowMessageView(failureresponse);
    }

    public UserRegisterResponseModel prepareSuccessView(String successresponse){
        throw new ShowMessageView(successresponse);
    }
}
