package screens.par_followed_org;

import screens.par_home.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParFollowedOrgActionListener implements ActionListener {
    public ParFollowedOrgPage parFollowerPage;

    /**Constructor for the action listener of the page appearing after the participant
     * follows an organizer.
     * It takes a participant's follower page as an input and sets it as an attribute.
     *
     * @param parFollowerPage The participant's followed organizers page.
     */
    public ParFollowedOrgActionListener(ParFollowedOrgPage parFollowerPage){
        this.parFollowerPage = parFollowerPage;
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
        } else if (actionCommand.equals("UnFollow")) {
            // TODO: This section is missing.
        }
    }
}
