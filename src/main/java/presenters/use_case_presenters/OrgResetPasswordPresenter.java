package presenters.use_case_presenters;

import screens.common_view.ShowMessageView;
import use_cases.user_reset_password_use_case.UserResetPasswordOutputBoundary;
import use_cases.user_reset_password_use_case.UserResetPasswordResponseModel;

public class OrgResetPasswordPresenter implements UserResetPasswordOutputBoundary {
    @Override
    public UserResetPasswordResponseModel prepareFailureView(String message) {
        //Use ShowMessageView to show the message
        throw new ShowMessageView(message);
    }

    @Override
    public UserResetPasswordResponseModel prepareSuccessView(UserResetPasswordResponseModel responseModel) {
        responseModel.setMessage(responseModel.getMessage());
        //Return the response model
        return responseModel;
    }


}
