package presenters.use_case_presenters;

import screens.common_view.ShowMessageView;
import use_cases.user_login_use_case.UserLoginOutputBoundary;
import use_cases.user_login_use_case.UserLoginResponseModel;

// Interface adapters layer

public class UserLoginPresenter implements UserLoginOutputBoundary {
    @Override
    public UserLoginResponseModel prepareFailView(String error) {
        throw new ShowMessageView(error);
    }
}