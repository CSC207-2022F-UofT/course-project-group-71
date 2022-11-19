package screens.par_home;

import user_login_use_case.ParHomeOutputBoundary;
import user_login_use_case.UserLoginResponseModel;

public class ParHomePresenter implements ParHomeOutputBoundary {
    public UserLoginResponseModel prepareHomePageView(UserLoginResponseModel participant){
        return participant;
    }
}
