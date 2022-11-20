package screens.par_search;

import database.*;
import par_join_event_use_case.ParJoinEventInputBoundary;
import par_join_event_use_case.ParJoinEventInteractor;
import par_join_event_use_case.ParJoinEventOutputBoundary;
import par_join_event_use_case.ParJoinEventResponseModel;
import par_leave_event_use_case.ParLeaveEventInputBoundary;
import par_leave_event_use_case.ParLeaveEventInteractor;
import par_leave_event_use_case.ParLeaveEventOutputBoundary;
import par_leave_event_use_case.ParLeaveEventResponseModel;
import screens.EventDetailsPage;
import screens.par_home.ParHomePage;
import screens.par_join_event.ParJoinEventController;
import screens.par_join_event.ParJoinEventPresenter;
import screens.par_upcoming_event.ParLeaveEventController;
import screens.par_upcoming_event.ParLeaveEventPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ParSearchEventResultsPageActionListener implements ActionListener {

    public ParSearchEventResultsPage parSearchEventResultsPage;
    private String eventName;

    public ParSearchEventResultsPageActionListener(ParSearchEventResultsPage parSearchEventResultsPage, String eventName) {
        this.parSearchEventResultsPage = parSearchEventResultsPage;
        this.eventName = eventName;

    }

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
            this.parSearchEventResultsPage.dispose();
            try {
                new ParSearchEventResultsPage(this.parSearchEventResultsPage.getEventNames(), parUserName);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this.parSearchEventResultsPage, response.getMessage());


        } else if (actionCommand.equals("Leave " + this.eventName)){
            ParDsGateway parDsGateway = new ParFileUser();
            OrgDsGateway orgDsGateway = new OrgFileUser();
            EventDsGateway eventDsGateway = new EventFileUser();

            ParLeaveEventOutputBoundary presenter = new ParLeaveEventPresenter();
            ParLeaveEventInputBoundary interactor = new ParLeaveEventInteractor(parDsGateway, orgDsGateway,presenter);
            ParLeaveEventController controller = new ParLeaveEventController(interactor);
            String parUserName = this.parSearchEventResultsPage.getParUsername();
            ParLeaveEventResponseModel response = null;
            try {
                response = controller.leave(parUserName, this.eventName);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            this.parSearchEventResultsPage.dispose();

            parUserName = this.parSearchEventResultsPage.getParUsername();
            JOptionPane.showMessageDialog(this.parSearchEventResultsPage, response.getMessage());
            try {
                new ParSearchEventResultsPage(this.parSearchEventResultsPage.getEventNames(), parUserName);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

        }
        else {
            try {
                new EventDetailsPage(eventName);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }


    }
}
