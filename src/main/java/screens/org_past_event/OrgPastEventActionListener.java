package screens.org_past_event;

import database.*;
import org_delete_event_use_case.OrgDeleteEventInputBoundary;
import org_delete_event_use_case.OrgDeleteEventInteractor;
import org_delete_event_use_case.OrgDeleteEventOutputBoundary;
import org_delete_event_use_case.OrgDeleteEventResponseModel;
import screens.EventDetailsPage;
import screens.org_home.OrgHomePage;
import screens.org_upcoming_event.OrgDeleteEventController;
import screens.org_upcoming_event.OrgDeleteEventPresenter;

import javax.swing.*;
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
        //Action made by user clicking "Delete"
        else if (actionCommand.contains("Delete")) {
            //Initialize the file users, presenters, interactor and controller
            EventDsGateway eventDsGateway = new EventFileUser();
            OrgDsGateway orgDsGateway = new OrgFileUser();
            ParDsGateway parDsGateway = new ParFileUser();
            OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary = new OrgDeleteEventPresenter();
            OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway, orgDsGateway,
                    parDsGateway, orgDeleteEventOutputBoundary);
            OrgDeleteEventController orgDeleteEventController = new OrgDeleteEventController(interactor);
            //Get the event name from the string shown on the button
            String eventName = actionCommand.substring(0,actionCommand.length()-6);

            //Try using controller to delete an event
            try{
                OrgDeleteEventResponseModel responseModel = orgDeleteEventController.delete(eventName);
                JOptionPane.showMessageDialog(this.orgPastEventPage, responseModel.getMessage());
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this.orgPastEventPage, e.getMessage());
            }
            //Dispose the current page
            this.orgPastEventPage.dispose();
            //Trying to regenerate the page
            try {
                new OrgPastEventPage(this.orgPastEventPage.getOrgUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        //Catch the exceptions
        else {
            try {
                new EventDetailsPage(actionCommand);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
