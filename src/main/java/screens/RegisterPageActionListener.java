package screens;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import screens.org_home.OrgHomePresenter;
import screens.par_home.ParHomePresenter;
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
            UserLoginOutputBoundary userLoginOutputBoundary =  new UserLoginPresenter();

            ParDsGateway parDsGateway = new ParFileUser();

            ParHomeOutputBoundary parHomeOutputBoundary =  new ParHomePresenter();

            OrgDsGateway orgDsGateway= new OrgFileUser();

            OrgHomeOutputBoundary orgHomeOutputBoundary =  new OrgHomePresenter();

            UserLoginInputBoundary interactor = new UserLoginInteractor(
                    userLoginOutputBoundary, parDsGateway, parHomeOutputBoundary, orgDsGateway, orgHomeOutputBoundary);

            UserLoginController userLoginController = new UserLoginController(interactor);

            this.registerPage.dispose();

            new LoginPage(userLoginController);
        }
        else {
            this.registerPage.dispose();
        }
    }
}
