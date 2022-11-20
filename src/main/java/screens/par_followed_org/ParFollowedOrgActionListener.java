package screens.par_followed_org;

import database.ParDsGateway;
import database.ParFileUser;
import par_unfollow_org_use_case.ParUnfollowOrgInputBoundary;
import par_unfollow_org_use_case.ParUnfollowOrgInteractor;
import par_unfollow_org_use_case.ParUnfollowOrgOutputBoundary;
import par_unfollow_org_use_case.ParUnfollowOrgResponseModel;
import screens.OrgDetailsPage;
import screens.par_follow_org_screens.ParUnfollowOrgController;
import screens.par_follow_org_screens.ParUnfollowOrgPresenter;
import screens.par_home.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ParFollowedOrgActionListener implements ActionListener {
    public ParFollowedOrgPage parFollowerPage;
    private String orgName;

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

            try {
                new ParFollowedOrgPage(this.parFollowerPage.getParUsername());
                this.parFollowerPage.dispose();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                new OrgDetailsPage(this.orgName);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
