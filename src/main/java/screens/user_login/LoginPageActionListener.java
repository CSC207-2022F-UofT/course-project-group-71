package screens.user_login;

import screens.user_register.RegisterPage;
import controllers.UserRegisterController;
import presenters.use_case_presenters.UserRegisterPresenter;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import use_cases.user_register_use_case.UserRegisterInputBoundary;
import use_cases.user_register_use_case.UserRegisterInteractor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPageActionListener implements ActionListener {
    private final LoginPage LOGIN_PAGE;
    public LoginPageActionListener(LoginPage LOGIN_PAGE){
        this.LOGIN_PAGE = LOGIN_PAGE;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String page = actionEvent.getActionCommand();

        if (page.equals("To Register Page")) {
            ParDsGateway par = new ParFileUser();
            OrgDsGateway org = new OrgFileUser();
            UserRegisterPresenter presenter = new UserRegisterPresenter();
            UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                    par, org, presenter);
            UserRegisterController userRegisterController = new UserRegisterController(interactor);
            this.LOGIN_PAGE.dispose();
            new RegisterPage(userRegisterController);
        }
        else {
            this.LOGIN_PAGE.dispose();
        }
    }
}
