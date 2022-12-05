package controller_presenter_view.screens.par_account;

import controller_presenter_view.screens.par_account.par_reset_password.ParResetPasswordController;
import controller_presenter_view.screens.par_account.par_reset_password.ParResetPasswordPresenter;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import controller_presenter_view.screens.par_home.ParHomePage;
import use_cases.user_reset_password_use_case.UserResetPasswordInputBoundary;
import use_cases.user_reset_password_use_case.UserResetPasswordInteractor;
import use_cases.user_reset_password_use_case.UserResetPasswordOutputBoundary;
import use_cases.user_reset_password_use_case.UserResetPasswordResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParAccountActionListener implements ActionListener {
    private final ParAccountPage parAccountPage;

    /**The constructor class for action listener, it's going to take a page and listen to the change from the page.
     *
     * @param parAccountPage The page that's showing to the user
     */
    public ParAccountActionListener(ParAccountPage parAccountPage){
        this.parAccountPage = parAccountPage;
    }

    /**Send user back to participant homepage when User clicks "Back"
     * After clicking "Reset Password", the reset password controller is called, the message of success or failure
     * is going to be shown, and the current page is going to be refreshed.
     *
     * @param arg0 the event to be processed
     */
    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parAccountPage.dispose();
            new ParHomePage(this.parAccountPage.getParUsername());
        }
        else if (actionCommand.equals("Reset Password")) {
            UserResetPasswordOutputBoundary userResetPasswordOutputBoundary = new ParResetPasswordPresenter();

            ParDsGateway parDsGateway = new ParFileUser();

            OrgDsGateway orgDsGateway = new OrgFileUser();


            UserResetPasswordInputBoundary interactor = new UserResetPasswordInteractor(
                    userResetPasswordOutputBoundary, orgDsGateway, parDsGateway);

            ParResetPasswordController resetPasswordController = new ParResetPasswordController(interactor);

            String username = parAccountPage.getParUsername();
            String password = String.valueOf(parAccountPage.oldPassword.getPassword());
            String new_password = String.valueOf(parAccountPage.newPassword.getPassword());
            String retype_password = String.valueOf(parAccountPage.retypeNewPassword.getPassword());

            try{
                UserResetPasswordResponseModel responseModel = resetPasswordController.resetPassword(username, password, new_password, retype_password);
                JOptionPane.showMessageDialog(this.parAccountPage, responseModel.getMessage());
            } catch (Exception e){
                JOptionPane.showMessageDialog(this.parAccountPage, e.getMessage());
            }
            this.parAccountPage.dispose();
            new ParAccountPage(this.parAccountPage.getParUsername());

        }
    }
}
