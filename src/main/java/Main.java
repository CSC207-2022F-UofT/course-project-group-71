import user_register_use_case.UserRegisterController;
import user_register_use_case.UserRegisterInputBoundary;
import user_register_use_case.UserRegisterInteractor;
import user_register_use_case.UserRegisterResponseFormatter;
import UserRegisterScreen.RegisterScreen;
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
        UserRegisterResponseFormatter presenter = new UserRegisterResponseFormatter();
        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                par, org, presenter);
        UserRegisterController userRegisterController = new UserRegisterController(interactor);

        new RegisterScreen(userRegisterController);

        // Build the GUI, plugging in the parts
//        LoginScreen loginScreen = new LoginScreen(userRegisterController);
//        screens.add(loginScreen, "welcome");
//        cardLayout.show(screens, "register");
//        application.pack();
//        application.setVisible(true);



    }

}