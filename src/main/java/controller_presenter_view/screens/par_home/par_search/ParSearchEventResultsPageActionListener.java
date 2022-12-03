package controller_presenter_view.screens.par_home.par_search;

import controller_presenter_view.common_controller_presenter.par_leave_event.ParLeaveEventController;
import controller_presenter_view.common_controller_presenter.par_leave_event.ParLeaveEventPresenter;
import controller_presenter_view.common_view.EventDetailsPage;
import controller_presenter_view.screens.par_home.ParHomePage;
import controller_presenter_view.screens.par_home.par_search.par_join_event.ParJoinEventController;
import controller_presenter_view.screens.par_home.par_search.par_join_event.ParJoinEventPresenter;
import database.ParDsGateway;
import database.ParFileUser;
import use_cases.par_join_event_use_case.ParJoinEventInputBoundary;
import use_cases.par_join_event_use_case.ParJoinEventInteractor;
import use_cases.par_join_event_use_case.ParJoinEventOutputBoundary;
import use_cases.par_join_event_use_case.ParJoinEventResponseModel;
import use_cases.par_leave_event_use_case.ParLeaveEventInputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventInteractor;
import use_cases.par_leave_event_use_case.ParLeaveEventOutputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParSearchEventResultsPageActionListener implements ActionListener {

    private final ParSearchEventResultsPage parSearchEventResultsPage;
    private final String eventName;

    /**Constructor of the event search results page action listener.
     * It takes a search results page and an event name as inputs
     * and stores them as attributes.
     *
     * @param parSearchEventResultsPage The participant's event search results page
     * @param eventName The name of the event the action is being performed on
     */
    public ParSearchEventResultsPageActionListener(ParSearchEventResultsPage parSearchEventResultsPage, String eventName) {
        this.parSearchEventResultsPage = parSearchEventResultsPage;
        this.eventName = eventName;
    }

    /**A method to deal with actions on the event search results page.
     * If the action command is back, the participant's home page is displayed.
     * If the action command is join, the participant attempts to join the event.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parSearchEventResultsPage.dispose();
            new ParHomePage(this.parSearchEventResultsPage.getParUsername());
        } else if (actionCommand.equals("Join " + this.eventName)) {

            ParDsGateway par = new ParFileUser();
            ParJoinEventOutputBoundary presenter = new ParJoinEventPresenter();
            ParJoinEventInputBoundary interactor = new ParJoinEventInteractor(par, presenter);
            ParJoinEventController controller = new ParJoinEventController(interactor);
            String parUserName = this.parSearchEventResultsPage.getParUsername();
            ParJoinEventResponseModel response = controller.join(parUserName, this.eventName);
            //show a success message that the participant has joined the event
            JOptionPane.showMessageDialog(this.parSearchEventResultsPage, response.getMessage());
            //dispose the results page
            this.parSearchEventResultsPage.dispose();
            try {
                new ParSearchEventResultsPage(this.parSearchEventResultsPage.getEventNames(), parUserName);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

        } else if (actionCommand.equals("Leave " + this.eventName)){
            ParDsGateway parDsGateway = new ParFileUser();

            ParLeaveEventOutputBoundary presenter = new ParLeaveEventPresenter();
            ParLeaveEventInputBoundary interactor = new ParLeaveEventInteractor(parDsGateway,presenter);
            ParLeaveEventController controller = new ParLeaveEventController(interactor);
            String parUserName = this.parSearchEventResultsPage.getParUsername();
            ParLeaveEventResponseModel responseModel;
            try {
                responseModel = controller.leave(parUserName, this.eventName);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            //show a success message that the participant has joined the event
            JOptionPane.showMessageDialog(this.parSearchEventResultsPage, responseModel.getMessage());
            //dispose the results page
            this.parSearchEventResultsPage.dispose();
            //renew the results page
            try {
                new ParSearchEventResultsPage(this.parSearchEventResultsPage.getEventNames(), parUserName);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            try {
                new EventDetailsPage(eventName);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }


    }
}
