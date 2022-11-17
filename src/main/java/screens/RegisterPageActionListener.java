package screens;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import screens.org_home.OrgHomeResponseFormatter;
import screens.par_home.ParHomeResponseFormatter;
import user_login_use_case.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPageActionListener implements ActionListener {
    public RegisterPage registerPage;

    /**The constructor of the RegisterPageActionListener.
     * It takes an input RegisterPage and store as instance.
     *
     * @param registerPage The page of registration
     */
    public RegisterPageActionListener(RegisterPage registerPage){
        this.registerPage = registerPage;
    }

    /**It only takes one event, it disposes the original registration page and respond a login page
     * when the button "To Login Page" is clicked.
     *
     * @param actionEvent the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String page = actionEvent.getActionCommand();

        if (page.equals("To Login Page")) {
            UserLoginPresenter userLoginPresenter =  new UserLoginResponseFormatter();

            ParDsGateway parDsGateway = new ParFileUser();

            ParHomePresenter parHomePresenter =  new ParHomeResponseFormatter();

            OrgDsGateway orgDsGateway= new OrgFileUser();

            OrgHomePresenter orgHomePresenter =  new OrgHomeResponseFormatter();

            UserLoginInputBoundary interactor = new UserLoginInteractor(
                    userLoginPresenter, parDsGateway, parHomePresenter, orgDsGateway, orgHomePresenter);

            UserLoginController userLoginController = new UserLoginController(interactor);

            this.registerPage.dispose();

            new LoginPage(userLoginController);
        }
        else {
            this.registerPage.dispose();
        }
    }
}
