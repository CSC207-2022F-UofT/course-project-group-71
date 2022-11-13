package screens.org_home;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import screens.LoginPage;
import screens.UserLoginController;
import screens.UserLoginResponseFormatter;
import screens.org_account.OrgAccountPage;
import screens.org_follower.OrgFollowerPage;
import screens.org_past_event.OrgPastEventPage;
import screens.org_unpublished_event.OrgUnpublishedEventPage;
import screens.org_upcoming_event.OrgUpcomingEventPage;
import screens.par_home.ParHomeResponseFormatter;
import user_login_use_case.*;

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

        if (page.equals("Account")) {
            new OrgAccountPage(this.orgHomePage.getOrgUsername());
        }
        else if (page.equals("Unpublished Event")) {
            new OrgUnpublishedEventPage(this.orgHomePage.getOrgUsername());
        }
        else if (page.equals("Upcoming Event")) {
            new OrgUpcomingEventPage(this.orgHomePage.getOrgUsername());
        }
        else if (page.equals("Past Event")) {
            new OrgPastEventPage(this.orgHomePage.getOrgUsername());
        }
        else if (page.equals(("Follower"))){
            new OrgFollowerPage(this.orgHomePage.getOrgUsername());
        }
        else {
            UserLoginPresenter userLoginPresenter =  new UserLoginResponseFormatter();

            ParDsGateway parDsGateway = new ParFileUser();

            ParHomePresenter parHomePresenter =  new ParHomeResponseFormatter();

            OrgDsGateway orgDsGateway= new OrgFileUser();

            OrgHomePresenter orgHomePresenter =  new OrgHomeResponseFormatter();

            UserLoginInputBoundary interactor = new UserLoginInteractor(
                    userLoginPresenter, parDsGateway, parHomePresenter, orgDsGateway, orgHomePresenter);

            UserLoginController userLoginController = new UserLoginController(interactor);

            new LoginPage(userLoginController);
        }
    }
}
