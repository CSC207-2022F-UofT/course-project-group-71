package screens.org_account;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import screens.org_home.OrgHomePage;
import user_reset_password_use_case.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgAccountActionListener implements ActionListener {
    public OrgAccountPage orgAccountPage;

    public OrgAccountActionListener(OrgAccountPage orgAccountPage){
        this.orgAccountPage = orgAccountPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.orgAccountPage.dispose();
            new OrgHomePage(this.orgAccountPage.getOrgUsername());
        }
        else if (actionCommand.equals("Reset Password")) {
            UserResetPasswordPresenter userResetPasswordPresenter = new UserResetPasswordFormatter();

            ParDsGateway parDsGateway = new ParFileUser();

            OrgDsGateway orgDsGateway = new OrgFileUser();


            UserResetPasswordInputBoundary interactor = new UserResetPasswordInteractor(
                    userResetPasswordPresenter, orgDsGateway, parDsGateway);

            OrgResetPasswordController resetPasswordController = new OrgResetPasswordController(interactor);

            String username = orgAccountPage.getOrgUsername();
            String password = String.valueOf(orgAccountPage.oldPassword.getPassword());
            String new_password = String.valueOf(orgAccountPage.newPassword.getPassword());
            String retype_password = String.valueOf(orgAccountPage.retypeNewPassword.getPassword());
            System.out.println("eeeee");

            try{
                UserResetPasswordResponseModel responseModel = resetPasswordController.resetPassword(username, password, new_password, retype_password);
                System.out.println(responseModel.getMessage());
                System.out.println("A");
                JOptionPane.showMessageDialog(this.orgAccountPage, responseModel.getMessage());
            } catch (Exception e){
                JOptionPane.showMessageDialog(this.orgAccountPage, e.getMessage());
            }
            this.orgAccountPage.dispose();
            new OrgAccountPage(this.orgAccountPage.getOrgUsername());

        }
    }
}
