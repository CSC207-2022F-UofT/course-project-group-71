package controller_presenter_view.screens.org_unpublished_event.org_create_event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgCreateEventPageActionListener implements ActionListener {

<<<<<<< HEAD
    public OrgCreateEventPage orgCreateEventPage;

    public OrgCreateEventPageActionListener(OrgCreateEventPage orgCreateEventPage){
        //Store the input page as an instance
        this.orgCreateEventPage = orgCreateEventPage;
=======
    final public OrgCreateEventPage ORG_CREATE_EVENT_PAGE;

    public OrgCreateEventPageActionListener(OrgCreateEventPage ORG_CREATE_EVENT_PAGE){
        //Store the input page as an instance
        this.ORG_CREATE_EVENT_PAGE = ORG_CREATE_EVENT_PAGE;
>>>>>>> main

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Close the current page
<<<<<<< HEAD
        this.orgCreateEventPage.dispose();
=======
        this.ORG_CREATE_EVENT_PAGE.dispose();
>>>>>>> main
    }
}