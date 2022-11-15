package user_register_use_case;

import user_login_use_case.UserLoginResponseModel;

public interface UserRegisterPresenter {
    UserRegisterResponseModel prepareFailView(String failureresponse);
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel responseModel);
}
