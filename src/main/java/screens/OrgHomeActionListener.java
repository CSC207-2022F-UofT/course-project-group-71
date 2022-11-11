package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgHomeActionListener implements ActionListener {
    public OrgHomePage orgHomePage;
    public OrgHomeActionListener(OrgHomePage orgHomePage){
        this.orgHomePage = orgHomePage;
    }

    public void actionPerformed(ActionEvent arg0){
        String page = arg0.getActionCommand();

        this.orgHomePage.dispose();

        if (page.equals("Account")) {
            new OrgAccountPage();
        }
        else if (page.equals("Unpublished Event")) {
            new OrgUnpublishedEventPage();
        }
        else if (page.equals("Upcoming Event")) {
            new OrgUpcomingEventPage();
        }
        else if (page.equals("Past Event")) {
            new OrgPastEventPage();
        }
        else {
            new OrgFollowerPage();
        }
    }
}
