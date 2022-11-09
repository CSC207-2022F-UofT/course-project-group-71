import UserRegister.UserRegisterController;
import UserRegister.UserRegisterInputBoundary;
import UserRegister.UserRegisterInteractor;
import UserRegister.UserRegisterPresenter;
import UserRegisterScreen.LoginScreen;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
//        JFrame application = new JFrame("Login Example");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);

        // Create the parts to plug into the Use Case+Entities engine
        ParDsGateway par = new ParFileUser();
        OrgDsGateway org = new OrgFileUser();
        UserRegisterPresenter presenter = new UserRegisterPresenter();
        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                par, org, presenter);
        UserRegisterController userRegisterController = new UserRegisterController(interactor);

        new LoginScreen(userRegisterController);

        // Build the GUI, plugging in the parts
//        LoginScreen loginScreen = new LoginScreen(userRegisterController);
//        screens.add(loginScreen, "welcome");
//        cardLayout.show(screens, "register");
//        application.pack();
//        application.setVisible(true);



    }

}