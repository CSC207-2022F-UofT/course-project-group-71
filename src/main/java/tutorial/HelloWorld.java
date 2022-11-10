package tutorial;

import database.OrgDsGateway;
import database.ParDsGateway;
import database.ParFileUser;
import database.OrgFileUser;
import screens.*;
import user_login_use_case.*;

import javax.swing.*;
import java.awt.*;

public class HelloWorld {
    public static void main(String[] args) {

        /* Build the main program window
        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
*/
        UserLoginPresenter userLoginPresenter =  new UserLoginResponseFormatter();

        ParDsGateway parDsGateway = new ParFileUser();//should we in take any argument???

        ParHomePresenter parHomePresenter =  new ParHomeResponseFormatter();

        OrgDsGateway orgDsGateway= new OrgFileUser();//should we in take any argument???
        
        OrgHomePresenter orgHomePresenter =  new OrgHomeResponseFormatter();

        UserLoginInputBoundary interactor = new UserLoginInteractor(
                userLoginPresenter, parDsGateway, parHomePresenter, orgDsGateway, orgHomePresenter);
        UserLoginController userLoginController = new UserLoginController(interactor);

        // Build the GUI, plugging in the parts
      //  LoginPage loginPage =
        new LoginPage(userLoginController);
     /*   screens.add(loginPage, "welcome");
        cardLayout.show(screens, "login");
        application.pack();
        application.setVisible(true);*/

        // Unused screens; we'll uncomment this later
//        WelcomeScreen welcomeScreen = new WelcomeScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        LoggedInScreen loggedInScreen = new LoggedInScreen();
//        screens.add(welcomeScreen, "login");
//        screens.add(loginScreen, "login");
//        screens.add(loggedInScreen, "loggedIn");

    }

}