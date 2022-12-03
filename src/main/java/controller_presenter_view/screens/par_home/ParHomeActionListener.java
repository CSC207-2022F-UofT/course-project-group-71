package controller_presenter_view.screens.par_home;

import controller_presenter_view.screens.par_account.ParAccountPage;
import controller_presenter_view.screens.par_followed_org.ParFollowedOrgPage;
import controller_presenter_view.screens.par_home.par_search.ParSearchEventController;
import controller_presenter_view.screens.par_home.par_search.ParSearchEventPresenter;
import controller_presenter_view.screens.par_home.par_search.ParSearchOrgController;
import controller_presenter_view.screens.par_home.par_search.ParSearchOrgPresenter;
import controller_presenter_view.screens.par_past_event.ParPastEventPage;
import controller_presenter_view.screens.par_upcoming_event.ParUpcomingEventPage;
import database.*;
import use_cases.par_search_event_use_case.ParSearchEventInputBoundary;
import use_cases.par_search_event_use_case.ParSearchEventInteractor;
import use_cases.par_search_event_use_case.ParSearchEventOutputBoundary;
import use_cases.par_search_org_use_case.ParSearchOrgInputBoundary;
import use_cases.par_search_org_use_case.ParSearchOrgInteractor;
import use_cases.par_search_org_use_case.ParSearchOrgOutputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controller_presenter_view.screens.user_register.RegisterPageBuilder.generateLoginPage;

public class ParHomeActionListener implements ActionListener {
    private final ParHomePage parHomePage;

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
        String parUsername = this.parHomePage.getParUsername();

        switch (page) {
            case "Account":
                this.parHomePage.dispose();
                new ParAccountPage(parUsername);
                break;
            case "Upcoming Event":
                this.parHomePage.dispose();
                try {
                    new ParUpcomingEventPage(parUsername);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Past Event":
                this.parHomePage.dispose();
                try {
                    new ParPastEventPage(parUsername);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Followed Org":
                this.parHomePage.dispose();
                try {
                    new ParFollowedOrgPage(parUsername);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Search":
                if (this.parHomePage.org.isSelected()) {//Search for Organization
                    try {
                        OrgDsGateway org = new OrgFileUser();
                        ParSearchOrgOutputBoundary presenter = new ParSearchOrgPresenter();
                        ParSearchOrgInputBoundary interactor = new ParSearchOrgInteractor(org, presenter);
                        ParSearchOrgController controller = new ParSearchOrgController(interactor);
                        String query = this.parHomePage.searchBox.getText();
                        try {
                            controller.orgSearch(query, parUsername); //draw screen
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        this.parHomePage.dispose();
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(this.parHomePage, error.getMessage());
                        new ParHomePage(parUsername);
                    }

                } else if (this.parHomePage.eve.isSelected()) {//Search for Event
                    try {
                        EventDsGateway eve = new EventFileUser();
                        ParSearchEventOutputBoundary presenter = new ParSearchEventPresenter(); //minor issue
                        ParSearchEventInputBoundary interactor = new ParSearchEventInteractor(eve, presenter);
                        ParSearchEventController controller = new ParSearchEventController(interactor);
                        String query = this.parHomePage.searchBox.getText();
                        try {
                            controller.eventSearch(query, parUsername);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        this.parHomePage.dispose();
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(this.parHomePage, error.getMessage());
                        new ParHomePage(parUsername);
                    }
                } else {
                    JOptionPane.showMessageDialog(this.parHomePage, "Please Select Search Target");
                }
                break;
            case "Log Out":
                this.parHomePage.dispose();
                generateLoginPage();
                break;
        }
    }
}

