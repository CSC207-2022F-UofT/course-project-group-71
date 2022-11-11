package screens.par_followed_org;

import screens.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParFollowedOrgActionListener implements ActionListener {
    public ParFollowedOrgPage parFollowerPage;

    public ParFollowedOrgActionListener(ParFollowedOrgPage parFollowerPage){
        this.parFollowerPage = parFollowerPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parFollowerPage.dispose();
            new ParHomePage(this.parFollowerPage.getParUsername());
        }
        else {

        }
    }
}
