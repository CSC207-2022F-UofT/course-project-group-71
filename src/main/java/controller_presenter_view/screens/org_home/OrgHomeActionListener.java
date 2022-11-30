package controller_presenter_view.screens.org_home;

import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventController;
import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventPresenter;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastController;
import controller_presenter_view.screens.org_account.OrgAccountPage;
import controller_presenter_view.screens.org_follower.OrgFollowerPage;
import controller_presenter_view.screens.org_past_event.OrgPastEventPage;
import controller_presenter_view.screens.org_unpublished_event.OrgUnpublishedEventPage;
import controller_presenter_view.screens.org_upcoming_event.OrgUpcomingEventPage;
import database.EventDsGateway;
import database.EventFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import use_cases.Util_Method;
import use_cases.notify_event_use_case.NotifyEventInputBoundary;
import use_cases.notify_event_use_case.NotifyEventInteractor;
import use_cases.notify_event_use_case.NotifyEventOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controller_presenter_view.screens.user_register.RegisterPageBuilder.generateLoginPage;

public class OrgHomeActionListener implements ActionListener {
    public final OrgHomePage orgHomePage;
    public OrgHomeActionListener(OrgHomePage orgHomePage){
        this.orgHomePage = orgHomePage;
    }

    public void actionPerformed(ActionEvent arg0) {
        String page = arg0.getActionCommand();

        this.orgHomePage.dispose();

        switch (page) {
            case "Account":
                new OrgAccountPage(this.orgHomePage.getOrgUsername());
                break;
            case "Unpublished Event":
                try {
                    new OrgUnpublishedEventPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Upcoming Event": {
                try {
                    new OrgUpcomingEventPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                UpcomingToPastController controller = Util_Method.utilGetUpcomingToPastControllerHelper();
                UpcomingToPastResponseModel responseModel;
                try {
                    responseModel = controller.convertToPast("O",
                            this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                if (!responseModel.getEventsToPast().isEmpty()) {
                    JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                    Util_Method.utilNotifyEventHelper(responseModel);
                }
                break;
            }
            case "Past Event": {
                try {
                    new OrgPastEventPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                UpcomingToPastController controller = Util_Method.utilGetUpcomingToPastControllerHelper();
                try {
                    new OrgPastEventPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                UpcomingToPastResponseModel responseModel;
                try {
                    responseModel = controller.convertToPast("O",
                            this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                if (!responseModel.getEventsToPast().isEmpty()) {
                    JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                    NotifyEventOutputBoundary orgNotifyEventOutputBoundary = new NotifyEventPresenter();
                    EventDsGateway eventDsGateway = new EventFileUser();
                    ParDsGateway parDsGateway = new ParFileUser();
                    NotifyEventInputBoundary interactor2 = new NotifyEventInteractor(eventDsGateway, parDsGateway,
                            orgNotifyEventOutputBoundary);
                    NotifyEventController notifyEventController = new NotifyEventController(interactor2);
                    for (String event : responseModel.getEventsToPast()) {
                        try {
                            notifyEventController.sendNotification("Past", event);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                break;
            }
            case "Follower":
                try {
                    new OrgFollowerPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default: {
                generateLoginPage();
                break;
            }
        }
    }
}
