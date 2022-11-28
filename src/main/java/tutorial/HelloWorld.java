package tutorial;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import controller_presenter_view.screens.user_login.LoginPage;
import controller_presenter_view.screens.user_login.UserLoginController;
import controller_presenter_view.screens.user_login.UserLoginPresenter;
import controller_presenter_view.screens.org_home.OrgHomePresenter;
import controller_presenter_view.screens.par_home.ParHomePresenter;
import use_cases.user_login_use_case.*;

public class HelloWorld {
    static int CONSTANT_X = 800;
    static int CONSTANT_Y = 800;
    static String databaseUrl = "jdbc:mysql://localhost:3306/db2";
    static String databaseUsername = "root";
    static String databasePassword = "Anitahua0105";
    public static String getDatabaseUrl() {return databaseUrl;}
    public static String getDatabaseUsername() {return databaseUsername;}
    public static String getDatabasePassword(){return databasePassword;}
    public static int getConstantX(){return CONSTANT_X;}
    public static int getConstantY(){return CONSTANT_Y;}
    public static void main(String[] args) {

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
