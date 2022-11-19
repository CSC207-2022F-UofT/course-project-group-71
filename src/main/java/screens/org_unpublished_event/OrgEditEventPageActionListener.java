package screens.org_unpublished_event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgEditEventPageActionListener implements ActionListener {

    public OrgEditEventPage orgEditEventPage;

    public OrgEditEventPageActionListener(OrgEditEventPage orgEditEventPage){
        this.orgEditEventPage = orgEditEventPage;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.orgEditEventPage.dispose();
    }
}