package screens.org_follower;

import screens.org_home.OrgHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgFollowerActionListener implements ActionListener {
    private final OrgFollowerPage orgFollowerPage;

    public OrgFollowerActionListener(OrgFollowerPage orgFollowerPage){
        //Set the follower page as instance
        this.orgFollowerPage = orgFollowerPage;
    }

    public void actionPerformed(ActionEvent arg0){//"Back"
        this.orgFollowerPage.dispose();
        new OrgHomePage(this.orgFollowerPage.getOrgUsername());
    }
}
