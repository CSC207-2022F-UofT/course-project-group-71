package screens;

import user_login_use_case.ParHomePresenter;
import user_login_use_case.UserLoginResponseModel;

public class ParHomeResponseFormatter implements ParHomePresenter {
    public UserLoginResponseModel prepareHomePageView(UserLoginResponseModel participant){
        return participant;
    }
}
