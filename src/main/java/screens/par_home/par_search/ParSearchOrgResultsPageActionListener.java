package screens.par_home.par_search;

import controllers.ParUnfollowOrgController;
import presenters.use_case_presenters.ParUnfollowOrgPresenter;
import screens.common_view.OrgDetailsPage;
import screens.par_home.ParHomePage;
import controllers.ParFollowOrgController;
import presenters.use_case_presenters.ParFollowOrgPresenter;
import database.ParDsGateway;
import database.ParFileUser;
import use_cases.par_follow_org_use_case.ParFollowOrgInputBoundary;
import use_cases.par_follow_org_use_case.ParFollowOrgInteractor;
import use_cases.par_follow_org_use_case.ParFollowOrgOutputBoundary;
import use_cases.par_follow_org_use_case.ParFollowOrgResponseModel;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgInputBoundary;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgInteractor;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgOutputBoundary;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParSearchOrgResultsPageActionListener implements ActionListener {

    private final ParSearchOrgResultsPage parSearchOrgResultsPage;
    private final String orgName;

    /**Constructor for the organizer search results page action listener.
     * It takes a search results page and an organizer name as inputs
     * and stores them as attributes.
     *
     * @param parSearchOrgResultsPage The participant's organizer search results page
     * @param orgName The name of the organizer the action is being performed on
     */
    public ParSearchOrgResultsPageActionListener(ParSearchOrgResultsPage parSearchOrgResultsPage, String orgName) {

        this.parSearchOrgResultsPage = parSearchOrgResultsPage;
        this.orgName = orgName;
    }

    /**A method to deal with actions on the organizer search results page.
     * If the action command is back, the participant's home page is displayed.
     * If the action command is follow or unfollow, the participant attempts to follow or unfollow the organizer.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parSearchOrgResultsPage.dispose();
            new ParHomePage(this.parSearchOrgResultsPage.getParUsername());

        } else if (actionCommand.equals("Follow " + this.orgName)) {
            //do the follow
            ParDsGateway par = new ParFileUser();
            ParFollowOrgOutputBoundary presenter = new ParFollowOrgPresenter();
            ParFollowOrgInputBoundary interactor = new ParFollowOrgInteractor(par, presenter);
            ParFollowOrgController controller = new ParFollowOrgController(interactor);
            String parUserName = this.parSearchOrgResultsPage.getParUsername();
            ParFollowOrgResponseModel responseModel;
            try {
                responseModel = controller.follow(parUserName, this.orgName);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            //show a success message that the participant has followed the organization
            JOptionPane.showMessageDialog(this.parSearchOrgResultsPage, responseModel.getMessage());
            //dispose the results page
            this.parSearchOrgResultsPage.dispose();
            //renew the results page
            try {
                new ParSearchOrgResultsPage(this.parSearchOrgResultsPage.getOrgNames(), parUserName);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

        } else if (actionCommand.equals("Unfollow " + this.orgName)) {
            //do unfollowing
            ParDsGateway par = new ParFileUser();
            ParUnfollowOrgOutputBoundary presenter = new ParUnfollowOrgPresenter();
            ParUnfollowOrgInputBoundary interactor = new ParUnfollowOrgInteractor(par, presenter);
            ParUnfollowOrgController controller = new ParUnfollowOrgController(interactor);
            String parUserName = this.parSearchOrgResultsPage.getParUsername();
            ParUnfollowOrgResponseModel responseModel;
            try {
                responseModel = controller.unfollow(parUserName, this.orgName);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            //show a success message that the participant has unfollowed the organization
            JOptionPane.showMessageDialog(this.parSearchOrgResultsPage, responseModel.getMessage());
            //dispose the results page
            this.parSearchOrgResultsPage.dispose();
            //renew the results page
            try {
                new ParSearchOrgResultsPage(this.parSearchOrgResultsPage.getOrgNames(), parUserName);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }


        } else {//show organization's detail page
            try {
                new OrgDetailsPage(this.orgName);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
