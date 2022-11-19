package screens.par_home;

import database.*;
import par_search_org_use_case.*;
import par_search_event_use_case.*;
import screens.LoginPage;
import screens.org_home.OrgHomePresenter;
import screens.UserLoginController;
import screens.UserLoginPresenter;
import screens.par_account.ParAccountPage;
import screens.par_followed_org.ParFollowedOrgPage;
import screens.par_past_event.ParPastEventPage;
import screens.par_upcoming_event.ParUpcomingEventPage;
import screens.upcoming_to_past.UpcomingToPastController;
import screens.upcoming_to_past.UpcomingToPastResponseFormatter;
import upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import upcoming_to_past_use_case.UpcomingToPastInteractor;
import upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import upcoming_to_past_use_case.UpcomingToPastResponseModel;
import user_login_use_case.*;
import screens.par_search.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ParHomeActionListener implements ActionListener {
    public ParHomePage parHomePage;

    /**The constructor of the par homepage listener
     *
     * @param parHomePage The homepage to be listened
     */
    public ParHomeActionListener(ParHomePage parHomePage) {
        this.parHomePage = parHomePage;
    }


    /**Method operating when an action is done and heard.
     * It sent user to the account page when user clicks "Account"
     * And it's generates and showing an upcoming event page when user clicks "Upcoming Event"
     * It generates and showing a past event page when user clicks "Past Event"
     * It generates and showing a followed organizer page when user clicks "Followed Org"
     * When user input something in the searching bar and clicks "Search", it jumps to the result of searching.
     *
     * @param arg0 the event to be processed
     */
    public void actionPerformed(ActionEvent arg0) {
        String page = arg0.getActionCommand();

        if (page.equals("Account")) {
            this.parHomePage.dispose();
            new ParAccountPage(this.parHomePage.getParUsername());
        } else if (page.equals("Upcoming Event")) {
            this.parHomePage.dispose();
            try {
                new ParUpcomingEventPage(this.parHomePage.getParUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            ParDsGateway parDsGateway = new ParFileUser();
            OrgDsGateway orgDsGateway = new OrgFileUser();
            EventDsGateway eventDsGateway = new EventFileUser();
            UpcomingToPastOutputBoundary upcomingToPastOutputBoundary = new UpcomingToPastResponseFormatter();
            UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                    eventDsGateway, upcomingToPastOutputBoundary);
            UpcomingToPastController controller = new UpcomingToPastController(interactor);
            UpcomingToPastResponseModel responseModel;
            try {
                responseModel = controller.convertToPast("P",
                        this.parHomePage.getParUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (!responseModel.getEventsToPast().isEmpty()){
                JOptionPane.showMessageDialog(this.parHomePage, responseModel.getMessage());
            }
        } else if (page.equals("Past Event")) {
            this.parHomePage.dispose();
            try {
                new ParPastEventPage(this.parHomePage.getParUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            ParDsGateway parDsGateway = new ParFileUser();
            OrgDsGateway orgDsGateway = new OrgFileUser();
            EventDsGateway eventDsGateway = new EventFileUser();
            UpcomingToPastOutputBoundary upcomingToPastOutputBoundary = new UpcomingToPastResponseFormatter();
            UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                    eventDsGateway, upcomingToPastOutputBoundary);
            UpcomingToPastController controller = new UpcomingToPastController(interactor);
            UpcomingToPastResponseModel responseModel;
            try {
                responseModel = controller.convertToPast("P",
                        this.parHomePage.getParUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (!responseModel.getEventsToPast().isEmpty()){
                JOptionPane.showMessageDialog(this.parHomePage, responseModel.getMessage());
            }
        } else if (page.equals("Followed Org")) {
            this.parHomePage.dispose();
            try {
                new ParFollowedOrgPage(this.parHomePage.getParUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (page.equals("Search")) {
            if (this.parHomePage.org.isSelected()) {
                OrgDsGateway org = new OrgFileUser();
                ParSearchOrgOutputBoundary presenter = new ParSearchOrgPresenter();
                ParSearchOrgInputBoundary interactor = new ParSearchOrgInteractor(org, presenter);
                ParSearchOrgController controller = new ParSearchOrgController(interactor);
                String query = this.parHomePage.searchBox.getText();
                String parUserName= this.parHomePage.getParUsername();
                try {
                    controller.orgSearch(query,parUserName); //draw screen
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                this.parHomePage.dispose();
            } else {
                EventDsGateway eve = new EventFileUser();
                ParSearchEventOutputBoundary presenter = new ParSearchEventPresenter(); //minor issue
                ParSearchEventInputBoundary interactor = new ParSearchEventInteractor(eve, presenter);
                ParSearchEventController controller = new ParSearchEventController(interactor);
                String query = this.parHomePage.searchBox.getText();
                String parUserName= this.parHomePage.getParUsername();
                try {
                    controller.eventSearch(query,parUserName);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                this.parHomePage.dispose();
            }
            } else {
                this.parHomePage.dispose();
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

