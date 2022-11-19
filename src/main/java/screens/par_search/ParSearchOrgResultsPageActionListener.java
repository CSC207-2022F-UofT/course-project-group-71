package screens.par_search;

import database.ParDsGateway;
import database.ParFileUser;
import par_unfollow_org_use_case.ParUnfollowOrgInputBoundary;
import par_unfollow_org_use_case.ParUnfollowOrgInteractor;
import par_unfollow_org_use_case.ParUnfollowOrgOutputBoundary;
import par_unfollow_org_use_case.ParUnfollowOrgResponseModel;
import screens.par_follow_org_screens.FollowOrgController;
import screens.par_follow_org_screens.ParFollowOrgPresenter;
import screens.par_follow_org_screens.UnfollowOrgController;
import screens.par_follow_org_screens.ParUnfollowOrgPresenter;
import screens.par_home.ParHomePage;
import par_follow_org_use_case.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ParSearchOrgResultsPageActionListener implements ActionListener {


    public ParSearchOrgResultsPage parSearchOrgResultsPage;
    private String orgName;

    public ParSearchOrgResultsPageActionListener(ParSearchOrgResultsPage parSearchOrgResultsPage, String orgName) {

        this.parSearchOrgResultsPage = parSearchOrgResultsPage;
        this.orgName = orgName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parSearchOrgResultsPage.dispose();
            new ParHomePage(this.parSearchOrgResultsPage.getParUsername());
        } else if (actionCommand.equals("Follow " + this.orgName)) {

            ParDsGateway par = new ParFileUser();
            ParFollowOrgOutputBoundary presenter = new ParFollowOrgPresenter();
            ParFollowOrgInputBoundary interactor = new ParFollowOrgInteractor(par,presenter);
            FollowOrgController controller = new FollowOrgController(interactor);
            String parUserName = this.parSearchOrgResultsPage.getParUsername();
            this.parSearchOrgResultsPage.dispose();
            ParFollowOrgResponseModel responseModel = null;
            try {
                responseModel = controller.follow(parUserName,this.orgName);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            JOptionPane.showMessageDialog(this.parSearchOrgResultsPage, responseModel.getMessage());
            new ParHomePage(this.parSearchOrgResultsPage.getParUsername());

        } else if (actionCommand.equals("Unfollow " + this.orgName)) {

            ParDsGateway par = new ParFileUser();
            ParUnfollowOrgOutputBoundary presenter = new ParUnfollowOrgPresenter();
            ParUnfollowOrgInputBoundary interactor = new ParUnfollowOrgInteractor(par, presenter);
            UnfollowOrgController controller = new UnfollowOrgController(interactor);
            String parUserName = this.parSearchOrgResultsPage.getParUsername();
            this.parSearchOrgResultsPage.dispose();
            ParUnfollowOrgResponseModel responseModel = null;
            try {
                responseModel = controller.unfollow(parUserName, this.orgName);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this.parSearchOrgResultsPage, responseModel.getMessage());
            new ParHomePage(this.parSearchOrgResultsPage.getParUsername());
        }

    }
}
