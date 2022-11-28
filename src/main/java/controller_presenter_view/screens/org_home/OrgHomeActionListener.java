package controller_presenter_view.screens.org_home;

import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventController;
import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventPresenter;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastController;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastPresenter;
import controller_presenter_view.screens.org_account.OrgAccountPage;
import controller_presenter_view.screens.org_follower.OrgFollowerPage;
import controller_presenter_view.screens.org_past_event.OrgPastEventPage;
import controller_presenter_view.screens.org_unpublished_event.OrgUnpublishedEventPage;
import controller_presenter_view.screens.org_upcoming_event.OrgUpcomingEventPage;
import database.*;
import use_cases.notify_event_use_case.NotifyEventInputBoundary;
import use_cases.notify_event_use_case.NotifyEventInteractor;
import use_cases.notify_event_use_case.NotifyEventOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInteractor;
import use_cases.upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static controller_presenter_view.screens.user_register.RegisterPageBuilder.generateLoginPage;

public class OrgHomeActionListener implements ActionListener {
    public OrgHomePage orgHomePage;
    public OrgHomeActionListener(OrgHomePage orgHomePage){
        this.orgHomePage = orgHomePage;
    }

    public void actionPerformed(ActionEvent arg0){
        String page = arg0.getActionCommand();

        this.orgHomePage.dispose();

        switch (page) {
            case "Account":
                new OrgAccountPage(this.orgHomePage.getOrgUsername());
                break;
            case "Unpublished Event":
                try {
                    new OrgUnpublishedEventPage(this.orgHomePage.getOrgUsername());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Upcoming Event": {
                try {
                    new OrgUpcomingEventPage(this.orgHomePage.getOrgUsername());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                ParDsGateway parDsGateway = new ParFileUser();
                OrgDsGateway orgDsGateway = new OrgFileUser();
                EventDsGateway eventDsGateway = new EventFileUser();
                UpcomingToPastOutputBoundary upcomingToPastOutputBoundary = new UpcomingToPastPresenter();
                UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                        eventDsGateway, upcomingToPastOutputBoundary);
                UpcomingToPastController controller = new UpcomingToPastController(interactor);
                UpcomingToPastResponseModel responseModel;
                try {
                    responseModel = controller.convertToPast("O",
                            this.orgHomePage.getOrgUsername());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                if (!responseModel.getEventsToPast().isEmpty()) {
                    JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                    NotifyEventOutputBoundary orgNotifyEventOutputBoundary = new NotifyEventPresenter();
                    NotifyEventInputBoundary interactor2 = new NotifyEventInteractor(eventDsGateway, parDsGateway,
                            orgNotifyEventOutputBoundary);
                    NotifyEventController notifyEventController = new NotifyEventController(interactor2);
                    for (String event : responseModel.getEventsToPast()) {
                        try {
                            notifyEventController.sendNotification("Past", event);
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                break;
            }
            case "Past Event": {
                try {
                    new OrgPastEventPage(this.orgHomePage.getOrgUsername());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                ParDsGateway parDsGateway = new ParFileUser();
                OrgDsGateway orgDsGateway = new OrgFileUser();
                EventDsGateway eventDsGateway = new EventFileUser();
                UpcomingToPastOutputBoundary upcomingToPastOutputBoundary = new UpcomingToPastPresenter();
                UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                        eventDsGateway, upcomingToPastOutputBoundary);
                UpcomingToPastController controller = new UpcomingToPastController(interactor);
                UpcomingToPastResponseModel responseModel;
                try {
                    responseModel = controller.convertToPast("O",
                            this.orgHomePage.getOrgUsername());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                if (!responseModel.getEventsToPast().isEmpty()) {
                    JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                    NotifyEventOutputBoundary orgNotifyEventOutputBoundary = new NotifyEventPresenter();
                    NotifyEventInputBoundary interactor2 = new NotifyEventInteractor(eventDsGateway, parDsGateway,
                            orgNotifyEventOutputBoundary);
                    NotifyEventController notifyEventController = new NotifyEventController(interactor2);
                    for (String event : responseModel.getEventsToPast()) {
                        try {
                            try {
                                notifyEventController.sendNotification("Past", event);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                break;
            }
            case "Follower":
                try {
                    new OrgFollowerPage(this.orgHomePage.getOrgUsername());
                } catch (SQLException | ClassNotFoundException e) {
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
