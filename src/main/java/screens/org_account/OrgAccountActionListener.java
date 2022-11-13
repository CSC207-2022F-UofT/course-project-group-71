package screens.org_account;

import screens.org_home.OrgHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgAccountActionListener implements ActionListener {
    public OrgAccountPage orgAccountPage;

    public OrgAccountActionListener(OrgAccountPage orgAccountPage){
        this.orgAccountPage = orgAccountPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.orgAccountPage.dispose();
            new OrgHomePage(this.orgAccountPage.getOrgUsername());
        }
        else {

        }
    }
}
