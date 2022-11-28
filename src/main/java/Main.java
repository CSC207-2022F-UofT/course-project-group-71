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

public class Main {
    static int CONSTANT_X = 800;
    static int CONSTANT_Y = 800;

    public static int getConstantX(){return CONSTANT_X;}
    public static int getConstantY(){return CONSTANT_Y;}
    public static void main(String[] args) {
        generateLoginPage();
    }

    public static UserLoginController generateLoginPage() {
        UserLoginOutputBoundary userLoginOutputBoundary =  new UserLoginPresenter();

        ParDsGateway parDsGateway = new ParFileUser();

        ParHomeOutputBoundary parHomeOutputBoundary =  new ParHomePresenter();

        OrgDsGateway orgDsGateway= new OrgFileUser();

        OrgHomeOutputBoundary orgHomeOutputBoundary =  new OrgHomePresenter();

        UserLoginInputBoundary interactor = new UserLoginInteractor(
                userLoginOutputBoundary, parDsGateway, parHomeOutputBoundary, orgDsGateway, orgHomeOutputBoundary);

        UserLoginController userLoginController = new UserLoginController(interactor);

        new LoginPage(userLoginController);

        return userLoginController;
    }

}
