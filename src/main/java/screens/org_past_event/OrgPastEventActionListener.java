package screens.org_past_event;

import screens.org_home.OrgHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgPastEventActionListener implements ActionListener {
    public OrgPastEventPage orgPastEventPage;

    public OrgPastEventActionListener(OrgPastEventPage orgPastEventPage){
        this.orgPastEventPage = orgPastEventPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.orgPastEventPage.dispose();
            new OrgHomePage(this.orgPastEventPage.getOrgUsername());
        }
        else {

        }
    }
}
