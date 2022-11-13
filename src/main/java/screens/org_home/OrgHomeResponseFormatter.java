package screens.org_home;

import user_login_use_case.OrgHomePresenter;
import user_login_use_case.UserLoginResponseModel;

public class OrgHomeResponseFormatter implements OrgHomePresenter {
    public UserLoginResponseModel prepareHomePageView(UserLoginResponseModel organization){
        return organization;
    }
}
