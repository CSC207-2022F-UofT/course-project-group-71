package screens.org_unpublished_event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgEditEventPageActionListener implements ActionListener {

    public OrgEditEventPage orgEditEventPage;

    public OrgEditEventPageActionListener(OrgEditEventPage orgEditEventPage){
        //Set the input page as the instance
        this.orgEditEventPage = orgEditEventPage;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Close the current page
        this.orgEditEventPage.dispose();
    }
}