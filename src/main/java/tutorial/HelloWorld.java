package tutorial;

import database.OrgDsGateway;
import database.ParDsGateway;
import database.ParFileUser;
import database.OrgFileUser;
import screens.*;
import screens.org_home.OrgHomeResponseFormatter;
import screens.par_home.ParHomeResponseFormatter;
import user_login_use_case.*;



public class HelloWorld {

    static int CONSTANT_X = 800;
    static int CONSTANT_Y = 800;

    static String databasePassword = "vvks1309";
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

    public static int getConstantX(){return CONSTANT_X;}
    public static int getConstantY(){return CONSTANT_Y;}
    public static String getDatabasePassword(){return databasePassword;}

}