package screens.par_home;

import database.*;
import org_search_use_case.*;
import event_search_use_case.*;
import screens.LoginPage;
import screens.org_home.OrgHomeResponseFormatter;
import screens.UserLoginController;
import screens.UserLoginResponseFormatter;
import screens.par_account.ParAccountPage;
import screens.par_followed_org.ParFollowedOrgPage;
import screens.par_past_event.ParPastEventPage;
import screens.par_upcoming_event.ParUpcomingEventPage;
import user_login_use_case.*;
import screens.search_screens.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParHomeActionListener implements ActionListener {
    public ParHomePage parHomePage;

    public ParHomeActionListener(ParHomePage parHomePage) {
        this.parHomePage = parHomePage;
    }


    public void actionPerformed(ActionEvent arg0) {
        String page = arg0.getActionCommand();

        if (page.equals("Account")) {
            this.parHomePage.dispose();
            new ParAccountPage(this.parHomePage.getParUsername());
        } else if (page.equals("Upcoming Event")) {
            this.parHomePage.dispose();
            new ParUpcomingEventPage(this.parHomePage.getParUsername());
        } else if (page.equals("Past Event")) {
            this.parHomePage.dispose();
            new ParPastEventPage(this.parHomePage.getParUsername());
        } else if (page.equals("Followed Org")) {
            this.parHomePage.dispose();
            new ParFollowedOrgPage(this.parHomePage.getParUsername());
        } else if (page.equals("Search")) {
            if (this.parHomePage.org.isSelected()) {
                OrgDsGateway org = new OrgFileUser();
                OrgSearchOutputBoundary presenter = new OrgSearchPresenter();
                OrgSearchInputBoundary interactor = new OrgSearchInteractor(org, presenter);
                OrgSearchController controller = new OrgSearchController(interactor);
                String query = this.parHomePage.searchBox.getText();
                String parUserName= this.parHomePage.getParUsername();
                controller.orgSearch(query,parUserName); //draw screen
                this.parHomePage.dispose();


            } else {
                EventDsGateway eve = new EventFileUser();
                EventSearchOutputBoundary presenter = new EventSearchPresenter(); //minor issue
                EventSearchInputBoundary interactor = new EventSearchInteractor(eve, presenter);
                EventSearchController controller = new EventSearchController(interactor);
                String query = this.parHomePage.searchBox.getText();
                String parUserName= this.parHomePage.getParUsername();
                controller.eventSearch(query,parUserName);
                this.parHomePage.dispose();

            }
            } else {
                this.parHomePage.dispose();
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

