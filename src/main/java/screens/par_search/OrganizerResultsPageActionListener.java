package screens.par_search;

import database.ParDsGateway;
import database.ParFileUser;
import par_unfollow_org_use_case.UnfollowOrgInputBoundary;
import par_unfollow_org_use_case.UnfollowOrgInteractor;
import par_unfollow_org_use_case.UnfollowOrgOutputBoundary;
import par_unfollow_org_use_case.UnfollowOrgResponseModel;
import screens.par_follow_org_screens.FollowOrgController;
import screens.par_follow_org_screens.FollowOrgPresenter;
import screens.par_follow_org_screens.UnfollowOrgController;
import screens.par_follow_org_screens.UnfollowOrgPresenter;
import screens.par_home.ParHomePage;
import par_follow_org_use_case.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OrganizerResultsPageActionListener implements ActionListener {


    public OrganizerResultsPage organizerResultsPage;
    private String orgName;

    public OrganizerResultsPageActionListener(OrganizerResultsPage organizerResultsPage, String orgName) {

        this.organizerResultsPage = organizerResultsPage;
        this.orgName = orgName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.organizerResultsPage.dispose();
            new ParHomePage(this.organizerResultsPage.getParUsername());
        } else if (actionCommand.equals("Follow " + this.orgName)) {

            ParDsGateway par = new ParFileUser();
            FollowOrgOutputBoundary presenter = new FollowOrgPresenter();
            FollowOrgInputBoundary interactor = new FollowOrgInteractor(par,presenter);
            FollowOrgController controller = new FollowOrgController(interactor);
            String parUserName = this.organizerResultsPage.getParUsername();
            this.organizerResultsPage.dispose();
            FollowOrgResponseModel responseModel = null;
            try {
                responseModel = controller.follow(parUserName,this.orgName);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            JOptionPane.showMessageDialog(this.organizerResultsPage, responseModel.getMessage());
            new ParHomePage(this.organizerResultsPage.getParUsername());

        } else if (actionCommand.equals("Unfollow " + this.orgName)) {

            ParDsGateway par = new ParFileUser();
            UnfollowOrgOutputBoundary presenter = new UnfollowOrgPresenter();
            UnfollowOrgInputBoundary interactor = new UnfollowOrgInteractor(par, presenter);
            UnfollowOrgController controller = new UnfollowOrgController(interactor);
            String parUserName = this.organizerResultsPage.getParUsername();
            this.organizerResultsPage.dispose();
            UnfollowOrgResponseModel responseModel = null;
            try {
                responseModel = controller.unfollow(parUserName, this.orgName);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this.organizerResultsPage, responseModel.getMessage());
            new ParHomePage(this.organizerResultsPage.getParUsername());
        }

    }
}
