package user_login_use_case;

public interface UserLoginPresenter {
    UserLoginResponseModel prepareFailView(String error);
}