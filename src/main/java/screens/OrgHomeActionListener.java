package screens;
import screens.org_account.OrgAccountPage;
import screens.org_follower.OrgFollowerPage;
import screens.org_past_event.OrgPastEventPage;
import screens.org_unpublished_event.OrgUnpublishedEventPage;
import screens.org_upcoming_event.OrgUpcomingEventPage;

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
            new OrgUpcomingEventPage(this.orgHomePage.getOrgUsername());
        }
        else if (page.equals("Past Event")) {
            new OrgPastEventPage();
        }
        else {
            new OrgFollowerPage();
        }
    }
}
