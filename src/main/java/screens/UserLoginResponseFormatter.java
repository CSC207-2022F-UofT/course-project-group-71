package screens;

import user_login_use_case.UserLoginPresenter;
import user_login_use_case.UserLoginResponseModel;

// Interface adapters layer

public class UserLoginResponseFormatter implements UserLoginPresenter {
    @Override

    public UserLoginResponseModel prepareFailView(String error) {
        throw new ShowMessageView(error);
    }
}