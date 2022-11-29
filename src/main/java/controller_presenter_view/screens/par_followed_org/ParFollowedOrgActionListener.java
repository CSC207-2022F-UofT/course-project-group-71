package controller_presenter_view.screens.par_followed_org;

import database.ParDsGateway;
import database.ParFileUser;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgInputBoundary;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgInteractor;
import use_cases.par_unfollow_org_use_case.ParUnfollowOrgOutputBoundary;
import controller_presenter_view.common_view.OrgDetailsPage;
import controller_presenter_view.common_controller_presenter.par_unfollow_org.ParUnfollowOrgController;
import controller_presenter_view.common_controller_presenter.par_unfollow_org.ParUnfollowOrgPresenter;
import controller_presenter_view.screens.par_home.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ParFollowedOrgActionListener implements ActionListener {
    final ParFollowedOrgPage parFollowerPage;
    final String orgName;

    /**Constructor for the action listener of the page appearing after the participant
     * follows an organizer.
     * It takes a participant's follower page and an organizers's name as inputs and
     * sets them as attributes.
     *
     * @param parFollowerPage The participant's followed organizers page.
     * @param orgName The organizer to be unfollowed.
     */
    public ParFollowedOrgActionListener(ParFollowedOrgPage parFollowerPage, String orgName){
        this.parFollowerPage = parFollowerPage;
        this.orgName = orgName;
    }

    /**Responds to actions performed on the participant's followed organizers page.
     * If the action is back, returns the participant's home page.
     * If the action is unfollow, the participant attempts to unfollow the organizer.
     *
     * @param arg0 the event to be processed
     */
    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parFollowerPage.dispose();
            new ParHomePage(this.parFollowerPage.getParUsername());
        } else if (actionCommand.equals(orgName + "UnFollow")) {
            String parUsername = this.parFollowerPage.getParUsername();
            ParDsGateway parDsGateway = new ParFileUser();
            ParUnfollowOrgOutputBoundary parUnfollowOrgPresenter = new ParUnfollowOrgPresenter();
            ParUnfollowOrgInputBoundary parUnfollowOrgInteractor = new ParUnfollowOrgInteractor(
                    parDsGateway, parUnfollowOrgPresenter);
            ParUnfollowOrgController parUnfollowOrgController = new ParUnfollowOrgController(
                    parUnfollowOrgInteractor);

            try {
                parUnfollowOrgController.unfollow(parUsername, this.orgName);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            new ParFollowedOrgPage(this.parFollowerPage.getParUsername());
            this.parFollowerPage.dispose();
        }
        else {
            new OrgDetailsPage(this.orgName);
        }
    }
}
