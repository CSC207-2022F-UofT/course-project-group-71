package screens.org_unpublished_event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgCreateEventPageActionListener implements ActionListener {

    public OrgCreateEventPage orgCreateEventPage;

    public OrgCreateEventPageActionListener(OrgCreateEventPage orgCreateEventPage){
        //Store the input page as an instance
        this.orgCreateEventPage = orgCreateEventPage;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Close the current page
        this.orgCreateEventPage.dispose();
    }
}