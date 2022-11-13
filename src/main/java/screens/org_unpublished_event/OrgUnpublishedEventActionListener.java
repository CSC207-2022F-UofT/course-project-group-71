package screens.org_unpublished_event;

import screens.org_home.OrgHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgUnpublishedEventActionListener implements ActionListener {
    public OrgUnpublishedEventPage orgUnpublishedEventPage;

    public OrgUnpublishedEventActionListener(OrgUnpublishedEventPage orgUnpublishedEventPage){
        this.orgUnpublishedEventPage = orgUnpublishedEventPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.orgUnpublishedEventPage.dispose();
            new OrgHomePage(this.orgUnpublishedEventPage.getOrgUsername());
        }
        else {

        }
    }
}
