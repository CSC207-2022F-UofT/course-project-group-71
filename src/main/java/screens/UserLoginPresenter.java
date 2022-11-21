package screens;

import user_login_use_case.UserLoginOutputBoundary;
import user_login_use_case.UserLoginResponseModel;

// Interface adapters layer

public class UserLoginPresenter implements UserLoginOutputBoundary {
    @Override
    public UserLoginResponseModel prepareFailView(String error) {
        System.out.println("a");
        throw new ShowMessageView(error);
    }
}