package screens.org_past_event;
import screens.EventDetailsPage;
import screens.org_home.OrgHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OrgPastEventActionListener implements ActionListener {
    public OrgPastEventPage orgPastEventPage;

    public OrgPastEventActionListener(OrgPastEventPage orgPastEventPage){
        this.orgPastEventPage = orgPastEventPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();
        //Action made by user clicked "Back"
        if (actionCommand.equals("Back")) {
            this.orgPastEventPage.dispose();
            new OrgHomePage(this.orgPastEventPage.getOrgUsername());
        }
        //open event detail page
        else {
            try {
                new EventDetailsPage(actionCommand);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
