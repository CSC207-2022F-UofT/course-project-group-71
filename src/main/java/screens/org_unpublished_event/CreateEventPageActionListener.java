package screens.search_screens;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org_create_event_use_case.OrgCreateEventPresenter;
import screens.LoginPage;
import org_create_event_use_case;
import screens.org_home.OrgHomeResponseFormatter;
import screens.org_unpublished_event.OrgCreateEventResponseFormatter;
import screens.par_home.ParHomeResponseFormatter;
import user_login_use_case.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateEventPageActionListener implements ActionListener {

    public CreateEventPage createEventPage;

    public CreateEventPageActionListener(CreateEventPage createEventPage){
        this.createEventPage= createEventPage;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.createEventPage.dispose();
        }
        else if (actionCommand.equals("Create")){
            /*OrgCreateEventPresenter OrgCreateEventPresenter =  new OrgCreateEventResponseFormatter();

            EventDsGateway eventDsGateway = new EventFileUser();

            ParHomePresenter parHomePresenter =  new ParHomeResponseFormatter();

            OrgDsGateway orgDsGateway= new OrgFileUser();
            OrgCreateEventPresenter orgCreateEventPresenter = new OrgCreateEventResponseFormatter();

            OrgCreateEventInputBoundary interactor = new OrgCreateEventInteractor(eventDsGateway, orgDsGateway, orgCreateEventPresenter);

            OrgCreateEventController orgCreateEventController = new OrgCreateEventController(interactor);

            orgCreateEventController.create(String orgUsername,
                    String title,
            int status,
            String description,
            String location,
            int year,
            int month,
            int day,
            int hour,
            int minute)

            this.createEventPage.dispose();

            throw

             */
        }
    }
}