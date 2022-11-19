package screens.par_account;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import screens.org_past_event.OrgPastEventPage;
import screens.par_home.ParHomePage;
import user_reset_password_use_case.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ParAccountActionListener implements ActionListener {
    public ParAccountPage parAccountPage;

    /**The constructor of the ParAccountActionListener.
     * It takes an input ParAccountPage and stores it as instance.
     *
     * @param parAccountPage The account page for participants
     */
    public ParAccountActionListener(ParAccountPage parAccountPage){
        this.parAccountPage = parAccountPage;
    }

    /**It takes one event and presents a new page depending on the action command.
     * If the command is "Back," it responds a new participant home page.
     * If the command is "Reset Password," it disposes the participant account page and
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
            UserResetPasswordPresenter userResetPasswordPresenter = new UserResetPasswordFormatter();

            ParDsGateway parDsGateway = new ParFileUser();

            OrgDsGateway orgDsGateway = new OrgFileUser();


            UserResetPasswordInputBoundary interactor = new UserResetPasswordInteractor(
                    userResetPasswordPresenter, orgDsGateway, parDsGateway);

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
            try {
                new OrgPastEventPage(this.parAccountPage.getParUsername());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
