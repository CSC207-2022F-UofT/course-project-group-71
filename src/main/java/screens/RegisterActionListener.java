package screens;

import UserRegisterScreen.RegisterScreen;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import user_register_use_case.UserRegisterController;
import user_register_use_case.UserRegisterInputBoundary;
import user_register_use_case.UserRegisterInteractor;
import user_register_use_case.UserRegisterPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterActionListener implements ActionListener {
    public LoginPage loginPage;
    public RegisterActionListener(LoginPage loginPage){
        this.loginPage = loginPage;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ParDsGateway par = new ParFileUser();
        OrgDsGateway org = new OrgFileUser();
        UserRegisterPresenter presenter = new UserRegisterPresenter();
        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                par, org, presenter);
        UserRegisterController userRegisterController = new UserRegisterController(interactor);

        this.loginPage.dispose();
        new RegisterScreen(userRegisterController);
    }
}
