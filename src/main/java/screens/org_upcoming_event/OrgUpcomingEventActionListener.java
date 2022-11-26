package screens.org_upcoming_event;

import database.*;
import notify_event_use_case.NotifyEventInputBoundary;
import notify_event_use_case.NotifyEventInteractor;
import notify_event_use_case.NotifyEventOutputBoundary;
import notify_event_use_case.NotifyEventResponseModel;
import org_delete_event_use_case.OrgDeleteEventInputBoundary;
import org_delete_event_use_case.OrgDeleteEventInteractor;
import org_delete_event_use_case.OrgDeleteEventOutputBoundary;
import org_delete_event_use_case.OrgDeleteEventResponseModel;
import screens.EventDetailsPage;
import screens.notify_event.NotifyEventController;
import screens.notify_event.NotifyEventPresenter;
import screens.org_home.OrgHomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OrgUpcomingEventActionListener implements ActionListener {
    public OrgUpcomingEventPage orgUpcomingEventPage;
    public String orgUsername;

    public OrgUpcomingEventActionListener(OrgUpcomingEventPage orgUpcomingEventPage, String orgUsername){
        this.orgUpcomingEventPage = orgUpcomingEventPage;
        this.orgUsername = orgUsername;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.orgUpcomingEventPage.dispose();
            new OrgHomePage(this.orgUpcomingEventPage.getOrgUsername());
        }
        else if (actionCommand.contains("Notify")) {
            EventDsGateway eventDsGateway = new EventFileUser();

            ParDsGateway parDsGateway = new ParFileUser();

            NotifyEventOutputBoundary notifyEventOutputBoundary = new NotifyEventPresenter();

            NotifyEventInputBoundary interactor = new NotifyEventInteractor(eventDsGateway, parDsGateway, notifyEventOutputBoundary);

            NotifyEventController notifyEventController = new NotifyEventController(interactor);

            String eventName = actionCommand.substring(0,actionCommand.length()-6);

            try {
                NotifyEventResponseModel responseModel =
                        notifyEventController.sendNotification("Future", eventName);
                JOptionPane.showMessageDialog(this.orgUpcomingEventPage, responseModel.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this.orgUpcomingEventPage, e.getMessage());
            }
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
                JOptionPane.showMessageDialog(this.orgUpcomingEventPage, responseModel.getMessage());
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this.orgUpcomingEventPage, e.getMessage());
            }
            this.orgUpcomingEventPage.dispose();
            try {
                new OrgUpcomingEventPage(this.orgUsername);
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
