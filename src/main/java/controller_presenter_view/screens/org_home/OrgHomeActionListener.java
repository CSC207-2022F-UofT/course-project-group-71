package controller_presenter_view.screens.org_home;

import controller_presenter_view.screens.org_account.OrgAccountPage;
import controller_presenter_view.screens.org_follower.OrgFollowerPage;
import controller_presenter_view.screens.org_past_event.OrgPastEventPage;
import controller_presenter_view.screens.org_unpublished_event.OrgUnpublishedEventPage;
import controller_presenter_view.screens.org_upcoming_event.OrgUpcomingEventPage;
import controller_presenter_view.screens.Util_Method;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controller_presenter_view.screens.user_register.RegisterPageBuilder.generateLoginPage;

public class OrgHomeActionListener implements ActionListener {
    final public OrgHomePage orgHomePage;
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
                Util_Method.convertAndNotify("O", orgUsername);
                try {
                    new OrgUpcomingEventPage(orgUsername);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case "Past Event": {
                Util_Method.convertAndNotify("O", orgUsername);
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
                generateLoginPage();
                break;
            }
        }
    }
}

