package tutorial;

import database.OrgDsGateway;
import database.ParDsGateway;
import database.ParFileUser;
import database.OrgFileUser;
import screens.*;
import user_login_use_case.*;

public class HelloWorld {
    public static void main(String[] args) {

        UserLoginPresenter userLoginPresenter =  new UserLoginResponseFormatter();

        ParDsGateway parDsGateway = new ParFileUser();

        ParHomePresenter parHomePresenter =  new ParHomeResponseFormatter();

        OrgDsGateway orgDsGateway= new OrgFileUser();
        
        OrgHomePresenter orgHomePresenter =  new OrgHomeResponseFormatter();

        UserLoginInputBoundary interactor = new UserLoginInteractor(
                userLoginPresenter, parDsGateway, parHomePresenter, orgDsGateway, orgHomePresenter);

        UserLoginController userLoginController = new UserLoginController(interactor);

        new LoginPage(userLoginController);

    }

}