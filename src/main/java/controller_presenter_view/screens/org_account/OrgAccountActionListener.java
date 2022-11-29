package controller_presenter_view.screens.org_account;

import controller_presenter_view.screens.org_account.org_reset_password.OrgResetPasswordController;
import controller_presenter_view.screens.org_account.org_reset_password.OrgResetPasswordPresenter;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import controller_presenter_view.screens.org_home.OrgHomePage;
import use_cases.user_reset_password_use_case.UserResetPasswordInputBoundary;
import use_cases.user_reset_password_use_case.UserResetPasswordInteractor;
import use_cases.user_reset_password_use_case.UserResetPasswordOutputBoundary;
import use_cases.user_reset_password_use_case.UserResetPasswordResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgAccountActionListener implements ActionListener {
    final public OrgAccountPage orgAccountPage;

    public OrgAccountActionListener(OrgAccountPage orgAccountPage){
        this.orgAccountPage = orgAccountPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();
        //If the button clicked is "Back"
        if (actionCommand.equals("Back")) {
            //Dispose the account page
            this.orgAccountPage.dispose();
            //Generate a new page
            new OrgHomePage(this.orgAccountPage.getOrgUsername());
        }
        //If the button clicked is "Reset Password"
        else if (actionCommand.equals("Reset Password")) {
            //Initialize DsGateway, Controller, InputBoundary, OutBoundary
            UserResetPasswordOutputBoundary userResetPasswordOutputBoundary = new OrgResetPasswordPresenter();
            ParDsGateway parDsGateway = new ParFileUser();
            OrgDsGateway orgDsGateway = new OrgFileUser();
            UserResetPasswordInputBoundary interactor = new UserResetPasswordInteractor(
                    userResetPasswordOutputBoundary, orgDsGateway, parDsGateway);
            OrgResetPasswordController resetPasswordController = new OrgResetPasswordController(interactor);

            //Obtain username, passwords from the type input bar and buttons
            String username = orgAccountPage.getOrgUsername();
            String password = String.valueOf(orgAccountPage.oldPassword.getPassword());
            String new_password = String.valueOf(orgAccountPage.newPassword.getPassword());
            String retype_password = String.valueOf(orgAccountPage.retypeNewPassword.getPassword());
            System.out.println("eeeee");

            try{
                //Try to reset the password
                UserResetPasswordResponseModel responseModel = resetPasswordController.resetPassword(username, password, new_password, retype_password);
                System.out.println(responseModel.getMessage());
                System.out.println("A");
                JOptionPane.showMessageDialog(this.orgAccountPage, responseModel.getMessage());
            } catch (Exception e){
                //If meet some problem, show this one
                JOptionPane.showMessageDialog(this.orgAccountPage, e.getMessage());
            }
            //Dispose the page and regenerate the organizer account page
            this.orgAccountPage.dispose();
            new OrgAccountPage(this.orgAccountPage.getOrgUsername());

        }
    }
}
