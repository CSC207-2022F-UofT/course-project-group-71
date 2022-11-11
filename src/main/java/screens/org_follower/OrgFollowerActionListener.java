package screens.org_follower;

import database.ParDsGateway;
import database.ParFileUser;
import screens.OrgHomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgFollowerActionListener implements ActionListener {
    public OrgFollowerPage orgFollowerPage;

    public OrgFollowerActionListener(OrgFollowerPage orgFollowerPage){
        this.orgFollowerPage = orgFollowerPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.orgFollowerPage.dispose();
            new OrgHomePage(this.orgFollowerPage.getOrgUsername());
        }
        else {

        }
    }
}
