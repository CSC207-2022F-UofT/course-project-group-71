package controller_presenter_view.screens.user_login;

import controller_presenter_view.common_view.ShowMessageView;
import user_login_use_case.UserLoginOutputBoundary;
import user_login_use_case.UserLoginResponseModel;

// Interface adapters layer

public class UserLoginPresenter implements UserLoginOutputBoundary {
    @Override
    public UserLoginResponseModel prepareFailView(String error) {
        throw new ShowMessageView(error);
    }
}