package screens.org_home;
import database.*;
import screens.LoginPage;
import screens.UserLoginController;
import screens.UserLoginResponseFormatter;
import screens.org_account.OrgAccountPage;
import screens.org_follower.OrgFollowerPage;
import screens.org_past_event.OrgPastEventPage;
import screens.org_unpublished_event.OrgUnpublishedEventPage;
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

        switch (page) {
            case "Account":
                new OrgAccountPage(this.orgHomePage.getOrgUsername());
                break;
            case "Unpublished Event":
                new OrgUnpublishedEventPage(this.orgHomePage.getOrgUsername());
                break;
            case "Upcoming Event": {
                ParDsGateway parDsGateway = new ParFileUser();
                OrgDsGateway orgDsGateway = new OrgFileUser();
                EventDsGateway eventDsGateway = new EventFileUser();
                UpcomingToPastPresenter upcomingToPastPresenter = new UpcomingToPastResponseFormatter();
                UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                        eventDsGateway, upcomingToPastPresenter);
                UpcomingToPastController controller = new UpcomingToPastController(interactor);
                UpcomingToPastResponseModel responseModel = controller.convertToPast("O",
                        this.orgHomePage.getOrgUsername());
                JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                new OrgUpcomingEventPage(this.orgHomePage.getOrgUsername());
                break;
            }
            case "Past Event": {
                ParDsGateway parDsGateway = new ParFileUser();
                OrgDsGateway orgDsGateway = new OrgFileUser();
                EventDsGateway eventDsGateway = new EventFileUser();
                UpcomingToPastPresenter upcomingToPastPresenter = new UpcomingToPastResponseFormatter();
                UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                        eventDsGateway, upcomingToPastPresenter);
                UpcomingToPastController controller = new UpcomingToPastController(interactor);
                UpcomingToPastResponseModel responseModel = controller.convertToPast("O",
                        this.orgHomePage.getOrgUsername());
                JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
                new OrgPastEventPage(this.orgHomePage.getOrgUsername());
                break;
            }
            case ("Follower"):
                new OrgFollowerPage(this.orgHomePage.getOrgUsername());
                break;
            default: {
                UserLoginPresenter userLoginPresenter = new UserLoginResponseFormatter();

                ParDsGateway parDsGateway = new ParFileUser();

                ParHomePresenter parHomePresenter = new ParHomeResponseFormatter();

                OrgDsGateway orgDsGateway = new OrgFileUser();

                OrgHomePresenter orgHomePresenter = new OrgHomeResponseFormatter();

                UserLoginInputBoundary interactor = new UserLoginInteractor(
                        userLoginPresenter, parDsGateway, parHomePresenter, orgDsGateway, orgHomePresenter);

                UserLoginController userLoginController = new UserLoginController(interactor);

                new LoginPage(userLoginController);
                break;
            }
        }
    }
}
