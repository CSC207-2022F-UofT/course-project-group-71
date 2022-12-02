package controller_presenter_view.screens.org_home;

import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastController;
import controller_presenter_view.screens.org_account.OrgAccountPage;
import controller_presenter_view.screens.org_follower.OrgFollowerPage;
import controller_presenter_view.screens.org_past_event.OrgPastEventPage;
import controller_presenter_view.screens.org_unpublished_event.OrgUnpublishedEventPage;
import controller_presenter_view.screens.org_upcoming_event.OrgUpcomingEventPage;
import use_cases.Util_Method;
import use_cases.upcoming_to_past_use_case.UpcomingToPastResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controller_presenter_view.screens.user_register.RegisterPageBuilder.generateLoginPage;

public class OrgHomeActionListener implements ActionListener {
    public final OrgHomePage orgHomePage;
    public OrgHomeActionListener(OrgHomePage orgHomePage){
        this.orgHomePage = orgHomePage;
    }

    public void actionPerformed(ActionEvent arg0) {
        String page = arg0.getActionCommand();

        this.orgHomePage.dispose();


        switch (page) {
            case "Account":
                new OrgAccountPage(this.orgHomePage.getOrgUsername());
                break;
            case "Unpublished Event":
                try {
                    new OrgUnpublishedEventPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Upcoming Event": {
                try {
                    new OrgUpcomingEventPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                UpcomingToPastController controller = Util_Method.utilGetUpcomingToPastControllerHelper();
                utilAttemptToConvert(controller);
                break;
            }
            case "Past Event": {
                try {
                    new OrgPastEventPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                UpcomingToPastController controller = Util_Method.utilGetUpcomingToPastControllerHelper();
                try {
                    new OrgPastEventPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                utilAttemptToConvert(controller);
            }
            case "Follower":
                try {
                    new OrgFollowerPage(this.orgHomePage.getOrgUsername());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default: {
                generateLoginPage();
                break;
            }
        }
    }

    private void utilAttemptToConvert(UpcomingToPastController controller) {
        UpcomingToPastResponseModel responseModel;
        try {
            responseModel = controller.convertToPast("O",
                    this.orgHomePage.getOrgUsername());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (!responseModel.getEventsToPast().isEmpty()) {
            JOptionPane.showMessageDialog(this.orgHomePage, responseModel.getMessage());
            Util_Method.utilNotifyEventHelper(responseModel);
        }
    }
}
