package screens.org_unpublished_event;

import database.*;
import org_create_event_use_case.OrgCreateEventPresenter;
import org_create_event_use_case.*;
import screens.par_home.ParHomeResponseFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateEventPageActionListener implements ActionListener {

    public CreateEventPage createEventPage;

    public CreateEventPageActionListener(CreateEventPage createEventPage){
        this.createEventPage= createEventPage;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.createEventPage.dispose();
    }
}