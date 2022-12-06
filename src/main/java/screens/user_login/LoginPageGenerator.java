package screens.user_login;

import presenters.OrgHomePresenter;
import presenters.ParHomePresenter;
import controllers.UserLoginController;
import presenters.UserLoginPresenter;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import use_cases.user_login_use_case.*;

public class LoginPageGenerator {
    public static void generateLoginPage() {
        UserLoginOutputBoundary userLoginOutputBoundary =  new UserLoginPresenter();

        ParDsGateway parDsGateway = new ParFileUser();

        ParHomeOutputBoundary parHomeOutputBoundary =  new ParHomePresenter();

        OrgDsGateway orgDsGateway= new OrgFileUser();

        OrgHomeOutputBoundary orgHomeOutputBoundary =  new OrgHomePresenter();

        UserLoginInputBoundary interactor = new UserLoginInteractor(
                userLoginOutputBoundary, parDsGateway, parHomeOutputBoundary, orgDsGateway, orgHomeOutputBoundary);

        UserLoginController userLoginController = new UserLoginController(interactor);

        new LoginPage(userLoginController);
    }
}
