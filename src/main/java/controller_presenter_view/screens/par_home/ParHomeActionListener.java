package controller_presenter_view.screens.par_home;

import controller_presenter_view.screens.par_account.ParAccountPage;
import controller_presenter_view.screens.par_followed_org.ParFollowedOrgPage;
import controller_presenter_view.screens.par_home.par_search.ParSearchEventController;
import controller_presenter_view.screens.par_home.par_search.ParSearchEventPresenter;
import controller_presenter_view.screens.par_home.par_search.ParSearchOrgController;
import controller_presenter_view.screens.par_home.par_search.ParSearchOrgPresenter;
import controller_presenter_view.screens.par_past_event.ParPastEventPage;
import controller_presenter_view.screens.par_upcoming_event.ParUpcomingEventPage;
import database.EventDsGateway;
import database.EventFileUser;
import database.OrgDsGateway;
import database.OrgFileUser;
import use_cases.par_search_event_use_case.ParSearchEventInputBoundary;
import use_cases.par_search_event_use_case.ParSearchEventInteractor;
import use_cases.par_search_event_use_case.ParSearchEventOutputBoundary;
import use_cases.par_search_org_use_case.ParSearchOrgInputBoundary;
import use_cases.par_search_org_use_case.ParSearchOrgInteractor;
import use_cases.par_search_org_use_case.ParSearchOrgOutputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static controller_presenter_view.screens.user_register.RegisterPageBuilder.generateLoginPage;

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
        } else if (page.equals("Past Event")) {
            this.parHomePage.dispose();
            try {
                new ParPastEventPage(this.parHomePage.getParUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
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
                try {
                    OrgDsGateway org = new OrgFileUser();
                    ParSearchOrgOutputBoundary presenter = new ParSearchOrgPresenter();
                    ParSearchOrgInputBoundary interactor = new ParSearchOrgInteractor(org, presenter);
                    ParSearchOrgController controller = new ParSearchOrgController(interactor);
                    String query = this.parHomePage.searchBox.getText();
                    String parUserName = this.parHomePage.getParUsername();
                    try {
                        controller.orgSearch(query, parUserName); //draw screen
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    this.parHomePage.dispose();
                }catch (Exception error){
                    JOptionPane.showMessageDialog(this.parHomePage,error.getMessage());
                    new ParHomePage(this.parHomePage.getParUsername());
                }

            } else if(this.parHomePage.eve.isSelected()) {

                try {
                    EventDsGateway eve = new EventFileUser();
                    ParSearchEventOutputBoundary presenter = new ParSearchEventPresenter(); //minor issue
                    ParSearchEventInputBoundary interactor = new ParSearchEventInteractor(eve, presenter);
                    ParSearchEventController controller = new ParSearchEventController(interactor);
                    String query = this.parHomePage.searchBox.getText();
                    String parUserName = this.parHomePage.getParUsername();
                    try {
                        controller.eventSearch(query, parUserName);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    this.parHomePage.dispose();
                }catch (Exception error) {
                   JOptionPane.showMessageDialog(this.parHomePage,error.getMessage());
                   new ParHomePage(this.parHomePage.getParUsername());
                }
            }else{
                JOptionPane.showMessageDialog(this.parHomePage,"Please Select Search Target");
            }
            } else if(page.equals("Log Out")){
                this.parHomePage.dispose();
            generateLoginPage();

        }
        }
    }

