package user_login_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import screens.UserLoginPresenter;
import screens.org_home.OrgHomePresenter;
import screens.par_home.ParHomePresenter;

public class UserLoginTest {
    ParDsGateway parDsGateway = new ParFileUser();

    OrgDsGateway orgDsGateway = new OrgFileUser();

    UserLoginOutputBoundary presenter = new UserLoginPresenter();

    ParHomeOutputBoundary par_presenter = new ParHomePresenter();

    OrgHomeOutputBoundary org_presenter = new OrgHomePresenter();

    UserLoginInputBoundary interactor = new UserLoginInteractor(presenter, parDsGateway, par_presenter, orgDsGateway, org_presenter);


}
