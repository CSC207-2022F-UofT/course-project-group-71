package controller_presenter_view.screens.par_upcoming_event;

import controller_presenter_view.common_controller_presenter.par_leave_event.ParLeaveEventController;
import controller_presenter_view.common_controller_presenter.par_leave_event.ParLeaveEventPresenter;
import controller_presenter_view.common_view.EventDetailsPage;
import controller_presenter_view.screens.par_home.ParHomePage;
import database.ParDsGateway;
import database.ParFileUser;
import use_cases.par_leave_event_use_case.ParLeaveEventInputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventInteractor;
import use_cases.par_leave_event_use_case.ParLeaveEventOutputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ParUpcomingEventActionListener implements ActionListener {
    public final ParUpcomingEventPage parUpcomingEventPage;

    /**Constructor of the upcoming event page.
     * It gets an upcoming event page as input and store it as instance.
     *
     * @param parUpcomingEventPage The upcoming event page of the participants
     */
    public ParUpcomingEventActionListener(ParUpcomingEventPage parUpcomingEventPage){
        this.parUpcomingEventPage = parUpcomingEventPage;
    }

    /**A method that dealt with activated event including back and leave.
     * If back button is pressed, it will jump to the participant home page.
     * If the Leave button is pressed, it will refresh the page and make the participant leaving the event.
     *
     * @param arg0 the event to be processed
     */
    public void actionPerformed(ActionEvent arg0) {
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parUpcomingEventPage.dispose();
            new ParHomePage(this.parUpcomingEventPage.getParUsername());
        } else if (actionCommand.contains("Leave")) {
            ParDsGateway parDsGateway = new ParFileUser();

            ParLeaveEventOutputBoundary parLeaveEventOutputBoundary = new ParLeaveEventPresenter();

            ParLeaveEventInputBoundary interactor = new ParLeaveEventInteractor(parDsGateway,
                    parLeaveEventOutputBoundary);

            ParLeaveEventController parLeaveEventController = new ParLeaveEventController(interactor);

            String eventName = actionCommand.substring(0, actionCommand.length() - 5);

            ParLeaveEventResponseModel responseModel;
            try {
                responseModel = parLeaveEventController.leave(
                        this.parUpcomingEventPage.getParUsername(), eventName);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            JOptionPane.showMessageDialog(this.parUpcomingEventPage, responseModel.getMessage());

            this.parUpcomingEventPage.dispose();
            new ParUpcomingEventPage(this.parUpcomingEventPage.getParUsername());
        }
        else {
            new EventDetailsPage(actionCommand);
        }
    }
}
