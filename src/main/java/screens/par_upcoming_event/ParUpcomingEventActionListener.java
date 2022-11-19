package screens.par_upcoming_event;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import par_leave_event_use_case.ParLeaveEventInputBoundary;
import par_leave_event_use_case.ParLeaveEventInteractor;
import par_leave_event_use_case.ParLeaveEventOutputBoundary;
import par_leave_event_use_case.ParLeaveEventResponseModel;
import screens.par_home.ParHomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ParUpcomingEventActionListener implements ActionListener {
    public ParUpcomingEventPage parUpcomingEventPage;

    public ParUpcomingEventActionListener(ParUpcomingEventPage parUpcomingEventPage){
        this.parUpcomingEventPage = parUpcomingEventPage;
    }

    public void actionPerformed(ActionEvent arg0) {
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parUpcomingEventPage.dispose();
            new ParHomePage(this.parUpcomingEventPage.getParUsername());
        } else if (actionCommand.contains("Leave")) {
            ParDsGateway parDsGateway = new ParFileUser();

            OrgDsGateway orgDsGateway = new OrgFileUser();

            ParLeaveEventOutputBoundary parLeaveEventOutputBoundary = new ParLeaveEventPresenter();

            ParLeaveEventInputBoundary interactor = new ParLeaveEventInteractor(parDsGateway, orgDsGateway,
                    parLeaveEventOutputBoundary);

            ParLeaveEventController parLeaveEventController = new ParLeaveEventController(interactor);

            String eventName = actionCommand.substring(0, actionCommand.length() - 5);

            ParLeaveEventResponseModel responseModel = null;
            try {
                responseModel = parLeaveEventController.leave(
                        this.parUpcomingEventPage.getParUsername(), eventName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            JOptionPane.showMessageDialog(this.parUpcomingEventPage, responseModel.getMessage());

            this.parUpcomingEventPage.dispose();
            try {
                new ParUpcomingEventPage(this.parUpcomingEventPage.getParUsername());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}