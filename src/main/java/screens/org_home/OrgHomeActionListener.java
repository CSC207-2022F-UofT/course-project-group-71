package screens.org_home;
import database.*;
import org_notify_event_use_case.OrgNotifyEventInputBoundary;
import org_notify_event_use_case.OrgNotifyEventInteractor;
import org_notify_event_use_case.OrgNotifyEventPresenter;
import org_notify_event_use_case.OrgNotifyEventResponseModel;
import screens.LoginPage;
import screens.UserLoginController;
import screens.UserLoginResponseFormatter;
import screens.org_account.OrgAccountPage;
import screens.org_follower.OrgFollowerPage;
import screens.org_past_event.OrgPastEventPage;
import screens.org_unpublished_event.OrgUnpublishedEventPage;
import screens.org_upcoming_event.OrgNotifyEventController;
import screens.org_upcoming_event.OrgNotifyEventResponseFormatter;
import screens.org_upcoming_event.OrgUpcomingEventPage;
import screens.par_home.ParHomeResponseFormatter;
import screens.upcoming_to_past.UpcomingToPastController;
import screens.upcoming_to_past.UpcomingToPastResponseFormatter;
import upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import upcoming_to_past_use_case.UpcomingToPastInteractor;
import upcoming_to_past_use_case.UpcomingToPastPresenter;
import upcoming_to_past_use_case.UpcomingToPastResponseModel;
import user_login_use_case.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            new OrgUnpublishedEventPage(this.orgHomePage.getOrgUsername());
        } else if (page.equals("Upcoming Event")) {
            new OrgUpcomingEventPage(this.orgHomePage.getOrgUsername());
            ParDsGateway parDsGateway = new ParFileUser();
            OrgDsGateway orgDsGateway = new OrgFileUser();
            EventDsGateway eventDsGateway = new EventFileUser();
            UpcomingToPastPresenter upcomingToPastPresenter = new UpcomingToPastResponseFormatter();
            UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                    eventDsGateway, upcomingToPastPresenter);
            UpcomingToPastController controller = new UpcomingToPastController(interactor);
            UpcomingToPastResponseModel responseModel = controller.convertToPast("O",
                    this.orgHomePage.getOrgUsername());
            if (!responseModel.getEventsToPast().isEmpty()){
                JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                OrgNotifyEventPresenter orgNotifyEventPresenter = new OrgNotifyEventResponseFormatter();
                OrgNotifyEventInputBoundary interactor2 = new OrgNotifyEventInteractor(eventDsGateway, parDsGateway,
                        orgNotifyEventPresenter);
                OrgNotifyEventController orgNotifyEventController = new OrgNotifyEventController(interactor2);
                for (String event : responseModel.getEventsToPast()){
                    orgNotifyEventController.sendNotification("Past", event);
                }
            }
        } else if (page.equals("Past Event")) {
            new OrgPastEventPage(this.orgHomePage.getOrgUsername());
            ParDsGateway parDsGateway = new ParFileUser();
            OrgDsGateway orgDsGateway = new OrgFileUser();
            EventDsGateway eventDsGateway = new EventFileUser();
            UpcomingToPastPresenter upcomingToPastPresenter = new UpcomingToPastResponseFormatter();
            UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                    eventDsGateway, upcomingToPastPresenter);
            UpcomingToPastController controller = new UpcomingToPastController(interactor);
            UpcomingToPastResponseModel responseModel = controller.convertToPast("O",
                    this.orgHomePage.getOrgUsername());
            if (!responseModel.getEventsToPast().isEmpty()){
                JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                OrgNotifyEventPresenter orgNotifyEventPresenter = new OrgNotifyEventResponseFormatter();
                OrgNotifyEventInputBoundary interactor2 = new OrgNotifyEventInteractor(eventDsGateway, parDsGateway,
                        orgNotifyEventPresenter);
                OrgNotifyEventController orgNotifyEventController = new OrgNotifyEventController(interactor2);
                for (String event : responseModel.getEventsToPast()){
                    orgNotifyEventController.sendNotification("Past", event);
                }
            }
        } else if (page.equals("Follower")) {
            new OrgFollowerPage(this.orgHomePage.getOrgUsername());
        } else{
            UserLoginPresenter userLoginPresenter = new UserLoginResponseFormatter();

            ParDsGateway parDsGateway = new ParFileUser();

            ParHomePresenter parHomePresenter = new ParHomeResponseFormatter();

            OrgDsGateway orgDsGateway = new OrgFileUser();

            OrgHomePresenter orgHomePresenter = new OrgHomeResponseFormatter();

            UserLoginInputBoundary interactor = new UserLoginInteractor(
                    userLoginPresenter, parDsGateway, parHomePresenter, orgDsGateway, orgHomePresenter);

            UserLoginController userLoginController = new UserLoginController(interactor);

            new LoginPage(userLoginController);
        }
    }
}
