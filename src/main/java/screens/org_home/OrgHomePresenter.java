package screens.org_home;

import user_login_use_case.OrgHomeOutputBoundary;
import user_login_use_case.UserLoginResponseModel;

public class OrgHomePresenter implements OrgHomeOutputBoundary {
    public UserLoginResponseModel prepareHomePageView(UserLoginResponseModel organization){
        return organization;
    }
}
