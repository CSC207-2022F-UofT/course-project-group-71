package screens.org_home;

import screens.org_account.OrgAccountPage;
import screens.org_follower.OrgFollowerPage;
import screens.org_past_event.OrgPastEventPage;
import screens.org_unpublished_event.OrgUnpublishedEventPage;
import screens.org_upcoming_event.OrgUpcomingEventPage;
import screens.CommonMethod;
import screens.user_login.LoginPageGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgHomeActionListener implements ActionListener {
    private final OrgHomePage orgHomePage;
    public OrgHomeActionListener(OrgHomePage orgHomePage){
        this.orgHomePage = orgHomePage;
    }

    public void actionPerformed(ActionEvent arg0){
        String page = arg0.getActionCommand();
        String orgUsername = this.orgHomePage.getOrgUsername();

        this.orgHomePage.dispose();

        switch (page) {
            case "Account":
                new OrgAccountPage(orgUsername);
                break;
            case "Unpublished Event":
                try {
                    new OrgUnpublishedEventPage(orgUsername);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Upcoming Event": {
                CommonMethod.convertAndNotify("O", orgUsername);
                try {
                    new OrgUpcomingEventPage(orgUsername);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case "Past Event": {
                CommonMethod.convertAndNotify("O", orgUsername);
                try {
                    new OrgPastEventPage(orgUsername);
                } catch ( ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case "Follower":
                try {
                    new OrgFollowerPage(orgUsername);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default: {//Log Out
                this.orgHomePage.dispose();
                LoginPageGenerator.generateLoginPage();
                break;
            }
        }
    }
}

