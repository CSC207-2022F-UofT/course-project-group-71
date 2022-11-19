package screens.org_unpublished_event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgCreateEventPageActionListener implements ActionListener {

    public OrgCreateEventPage orgCreateEventPage;

    public OrgCreateEventPageActionListener(OrgCreateEventPage orgCreateEventPage){
        this.orgCreateEventPage = orgCreateEventPage;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.orgCreateEventPage.dispose();
    }
}