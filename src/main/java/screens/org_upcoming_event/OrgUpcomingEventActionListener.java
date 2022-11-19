package screens.org_upcoming_event;

import database.*;
import org_delete_event_use_case.OrgDeleteEventInputBoundary;
import org_delete_event_use_case.OrgDeleteEventInteractor;
import org_delete_event_use_case.OrgDeleteEventPresenter;
import org_delete_event_use_case.OrgDeleteEventResponseModel;
import org_notify_event_use_case.OrgNotifyEventInputBoundary;
import org_notify_event_use_case.OrgNotifyEventInteractor;
import org_notify_event_use_case.OrgNotifyEventPresenter;
import org_notify_event_use_case.OrgNotifyEventResponseModel;
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

            OrgNotifyEventPresenter orgNotifyEventPresenter = new OrgNotifyEventResponseFormatter();

            OrgNotifyEventInputBoundary interactor = new OrgNotifyEventInteractor(eventDsGateway, parDsGateway, orgNotifyEventPresenter);

            OrgNotifyEventController orgNotifyEventController = new OrgNotifyEventController(interactor);

            String eventName = actionCommand.substring(0,actionCommand.length()-6);

            try {
                OrgNotifyEventResponseModel responseModel =
                        orgNotifyEventController.sendNotification("Future", eventName);
                JOptionPane.showMessageDialog(this.orgUpcomingEventPage, responseModel.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this.orgUpcomingEventPage, e.getMessage());
            }
        }
        else if (actionCommand.contains("Delete")) {
            EventDsGateway eventDsGateway = new EventFileUser();

            OrgDsGateway orgDsGateway = new OrgFileUser();

            ParDsGateway parDsGateway = new ParFileUser();

            OrgDeleteEventPresenter orgDeleteEventPresenter = new OrgDeleteEventResponseFormatter();

            OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway, orgDsGateway,
                    parDsGateway,orgDeleteEventPresenter);

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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {

        }
    }
}
