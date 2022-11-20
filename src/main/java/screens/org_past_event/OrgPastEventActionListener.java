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

        if (actionCommand.equals("Back")) {
            this.orgPastEventPage.dispose();
            new OrgHomePage(this.orgPastEventPage.getOrgUsername());
        }
        else if (actionCommand.contains("Delete")) {
            EventDsGateway eventDsGateway = new EventFileUser();

            OrgDsGateway orgDsGateway = new OrgFileUser();

            ParDsGateway parDsGateway = new ParFileUser();

            OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary = new OrgDeleteEventPresenter();

            OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway, orgDsGateway,
                    parDsGateway, orgDeleteEventOutputBoundary);

            OrgDeleteEventController orgDeleteEventController = new OrgDeleteEventController(interactor);

            String eventName = actionCommand.substring(0,actionCommand.length()-6);

            try{
                OrgDeleteEventResponseModel responseModel = orgDeleteEventController.delete(eventName);
                JOptionPane.showMessageDialog(this.orgPastEventPage, responseModel.getMessage());
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this.orgPastEventPage, e.getMessage());
            }
            this.orgPastEventPage.dispose();
            try {
                new OrgPastEventPage(this.orgPastEventPage.getOrgUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                new EventDetailsPage(actionCommand);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
