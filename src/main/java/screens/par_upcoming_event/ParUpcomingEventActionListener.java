package screens.par_upcoming_event;

import controllers.ParLeaveEventController;
import database.ParDsGateway;
import database.ParFileUser;
import presenters.use_case_presenters.ParLeaveEventPresenter;
import screens.CommonMethod;
import screens.common_view.EventDetailsPage;
import screens.par_home.ParHomePage;
import use_cases.par_leave_event_use_case.ParLeaveEventInputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventInteractor;
import use_cases.par_leave_event_use_case.ParLeaveEventOutputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParUpcomingEventActionListener implements ActionListener {
    private final ParUpcomingEventPage parUpcomingEventPage;

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
            //Leave the event
            ParDsGateway parDsGateway = new ParFileUser();
            ParLeaveEventOutputBoundary parLeaveEventOutputBoundary = new ParLeaveEventPresenter();
            ParLeaveEventInputBoundary interactor = new ParLeaveEventInteractor(parDsGateway,
                    parLeaveEventOutputBoundary);
            ParLeaveEventController parLeaveEventController = new ParLeaveEventController(interactor);
            String eventName = CommonMethod.keywordTaker(actionCommand, 5);
            ParLeaveEventResponseModel responseModel;
            try {
                responseModel = parLeaveEventController.leave(
                        this.parUpcomingEventPage.getParUsername(), eventName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            //Show success message of leaving
            JOptionPane.showMessageDialog(this.parUpcomingEventPage, responseModel.getMessage());
            //refresh the page
            this.parUpcomingEventPage.dispose();
            try {
                new ParUpcomingEventPage(this.parUpcomingEventPage.getParUsername());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                new EventDetailsPage(actionCommand);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
