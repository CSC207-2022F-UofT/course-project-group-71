package screens.org_home;

import database.*;
import notify_event_use_case.NotifyEventInputBoundary;
import notify_event_use_case.NotifyEventInteractor;
import notify_event_use_case.NotifyEventOutputBoundary;
import screens.LoginPage;
import screens.UserLoginController;
import screens.UserLoginPresenter;
import screens.notify_event.NotifyEventController;
import screens.notify_event.NotifyEventPresenter;
import screens.org_account.OrgAccountPage;
import screens.org_follower.OrgFollowerPage;
import screens.org_past_event.OrgPastEventPage;
import screens.org_unpublished_event.OrgUnpublishedEventPage;
import screens.org_upcoming_event.OrgUpcomingEventPage;
import screens.par_home.ParHomePresenter;
import screens.upcoming_to_past.UpcomingToPastController;
import screens.upcoming_to_past.UpcomingToPastPresenter;
import upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import upcoming_to_past_use_case.UpcomingToPastInteractor;
import upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import upcoming_to_past_use_case.UpcomingToPastResponseModel;
import user_login_use_case.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OrgHomeActionListener implements ActionListener {
    public OrgHomePage orgHomePage;
    public OrgHomeActionListener(OrgHomePage orgHomePage){
        this.orgHomePage = orgHomePage;
    }

    public void actionPerformed(ActionEvent arg0){
        String page = arg0.getActionCommand();

        this.orgHomePage.dispose();

        if (page.equals("Account")){
            new OrgAccountPage(this.orgHomePage.getOrgUsername());
        } else if (page.equals("Unpublished Event")) {
            try {
                new OrgUnpublishedEventPage(this.orgHomePage.getOrgUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (page.equals("Upcoming Event")) {
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
            if (!responseModel.getEventsToPast().isEmpty()){
                JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                NotifyEventOutputBoundary orgNotifyEventOutputBoundary = new NotifyEventPresenter();
                NotifyEventInputBoundary interactor2 = new NotifyEventInteractor(eventDsGateway, parDsGateway,
                        orgNotifyEventOutputBoundary);
                NotifyEventController notifyEventController = new NotifyEventController(interactor2);
                for (String event : responseModel.getEventsToPast()){
                    try {
                        notifyEventController.sendNotification("Past", event);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else if (page.equals("Past Event")) {
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
            if (!responseModel.getEventsToPast().isEmpty()){
                JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                NotifyEventOutputBoundary orgNotifyEventOutputBoundary = new NotifyEventPresenter();
                NotifyEventInputBoundary interactor2 = new NotifyEventInteractor(eventDsGateway, parDsGateway,
                        orgNotifyEventOutputBoundary);
                NotifyEventController notifyEventController = new NotifyEventController(interactor2);
                for (String event : responseModel.getEventsToPast()){
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
        } else if (page.equals("Follower")) {
            try {
                new OrgFollowerPage(this.orgHomePage.getOrgUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else{
            UserLoginOutputBoundary userLoginOutputBoundary = new UserLoginPresenter();

            ParDsGateway parDsGateway = new ParFileUser();

            ParHomeOutputBoundary parHomeOutputBoundary = new ParHomePresenter();

            OrgDsGateway orgDsGateway = new OrgFileUser();

            OrgHomeOutputBoundary orgHomeOutputBoundary = new OrgHomePresenter();

            UserLoginInputBoundary interactor = new UserLoginInteractor(
                    userLoginOutputBoundary, parDsGateway, parHomeOutputBoundary, orgDsGateway, orgHomeOutputBoundary);

            UserLoginController userLoginController = new UserLoginController(interactor);

            new LoginPage(userLoginController);
        }
    }
}
