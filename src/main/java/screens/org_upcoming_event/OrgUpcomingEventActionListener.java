package screens.org_upcoming_event;

import controllers.NotifyEventController;
import controllers.OrgDeleteEventController;
import database.EventDsGateway;
import database.EventFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import presenters.use_case_presenters.NotifyEventPresenter;
import screens.CommonMethod;
import screens.common_view.EventDetailsPage;
import screens.org_home.OrgHomePage;
import use_cases.notify_event_use_case.NotifyEventInputBoundary;
import use_cases.notify_event_use_case.NotifyEventInteractor;
import use_cases.notify_event_use_case.NotifyEventOutputBoundary;
import use_cases.notify_event_use_case.NotifyEventResponseModel;
import use_cases.org_delete_event_use_case.OrgDeleteEventResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgUpcomingEventActionListener implements ActionListener {
    private final OrgUpcomingEventPage orgUpcomingEventPage;

    public OrgUpcomingEventActionListener(OrgUpcomingEventPage orgUpcomingEventPage){
        this.orgUpcomingEventPage = orgUpcomingEventPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.orgUpcomingEventPage.dispose();
            new OrgHomePage(this.orgUpcomingEventPage.getOrgUsername());
        }
        else {
            if (actionCommand.contains("Notify")) {
                EventDsGateway eventDsGateway = new EventFileUser();
                ParDsGateway parDsGateway = new ParFileUser();
                NotifyEventOutputBoundary notifyEventOutputBoundary = new NotifyEventPresenter();
                NotifyEventInputBoundary interactor = new NotifyEventInteractor(eventDsGateway, parDsGateway, notifyEventOutputBoundary);
                NotifyEventController notifyEventController = new NotifyEventController(interactor);
                String eventName = CommonMethod.keywordTaker(actionCommand, 6);
                try {
                    NotifyEventResponseModel responseModel =
                            notifyEventController.sendNotification("Future", eventName);
                    JOptionPane.showMessageDialog(this.orgUpcomingEventPage, responseModel.getMessage());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this.orgUpcomingEventPage, e.getMessage());
                }
            }
            else if (actionCommand.contains("Delete")) {
                OrgDeleteEventController orgDeleteEventController = CommonMethod.utilGetDeleteEventControllerHelper();
                String eventName = CommonMethod.keywordTaker(actionCommand, 6);
                try{
                    OrgDeleteEventResponseModel responseModel = orgDeleteEventController.delete(eventName);
                    JOptionPane.showMessageDialog(this.orgUpcomingEventPage, responseModel.getMessage());
                } catch(ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this.orgUpcomingEventPage, e.getMessage());
                }
                this.orgUpcomingEventPage.dispose();
                try {
                    new OrgUpcomingEventPage(this.orgUpcomingEventPage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                try {
                    new EventDetailsPage(actionCommand);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
