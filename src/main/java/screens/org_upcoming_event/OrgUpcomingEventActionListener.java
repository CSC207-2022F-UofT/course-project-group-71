package screens.org_upcoming_event;

import screens.OrgHomePage;
import database.*;
import org_notify_event_use_case.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgUpcomingEventActionListener implements ActionListener {
    public OrgUpcomingEventPage orgUpcomingEventPage;

    public OrgUpcomingEventActionListener(OrgUpcomingEventPage orgUpcomingEventPage){
        this.orgUpcomingEventPage = orgUpcomingEventPage;
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
                OrgNotifyEventResponseModel responseModel = orgNotifyEventController.sendNotification(eventName);
                JOptionPane.showMessageDialog(this.orgUpcomingEventPage, responseModel.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this.orgUpcomingEventPage, e.getMessage());
            }
        }
        else if (actionCommand.contains("Delete")) {

        }
        else {

        }
    }
}
