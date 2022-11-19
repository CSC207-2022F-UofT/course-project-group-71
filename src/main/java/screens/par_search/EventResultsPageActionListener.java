package screens.par_search;

import database.ParDsGateway;
import database.ParFileUser;
import par_follow_org_use_case.FollowOrgResponseModel;
import screens.par_home.ParHomePage;
import par_join_event_use_case.*;
import screens.par_join_event.ParJoinEventController;
import screens.par_join_event.ParJoinEventPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EventResultsPageActionListener implements ActionListener {

    public EventResultsPage eventResultsPage;
    private String eventName;

    public EventResultsPageActionListener(EventResultsPage eventResultsPage, String eventName) {
        this.eventResultsPage = eventResultsPage;
        this.eventName = eventName;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.eventResultsPage.dispose();
            new ParHomePage(this.eventResultsPage.getParUsername());
        } else if (actionCommand.equals("Join " + this.eventName)) {

            ParDsGateway par = new ParFileUser();
            ParJoinEventOutputBoundary presenter = new ParJoinEventPresenter();
            ParJoinEventInputBoundary interactor = new ParJoinEventInteractor(par, presenter);
            ParJoinEventController controller = new ParJoinEventController(interactor);
            String parUserName = this.eventResultsPage.getParUsername();
            ParJoinEventResponseModel response = controller.join(parUserName, this.eventName);
            this.eventResultsPage.dispose();

            JOptionPane.showMessageDialog(this.eventResultsPage, response.getMessage());
            new ParHomePage(this.eventResultsPage.getParUsername());

        } else if (actionCommand.equals("Leave " + this.eventName) {


        }


    }
}
}