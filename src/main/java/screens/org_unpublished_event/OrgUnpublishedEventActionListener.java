package screens.org_unpublished_event;

import database.*;
import org_create_event_use_case.OrgCreateEventInputBoundary;
import org_create_event_use_case.OrgCreateEventInteractor;
import org_create_event_use_case.OrgCreateEventOutputBoundary;
import org_delete_event_use_case.OrgDeleteEventInputBoundary;
import org_delete_event_use_case.OrgDeleteEventInteractor;
import org_delete_event_use_case.OrgDeleteEventOutputBoundary;
import org_delete_event_use_case.OrgDeleteEventResponseModel;
import org_edit_event_use_case.OrgEditEventInputBoundary;
import org_edit_event_use_case.OrgEditEventInteractor;
import org_edit_event_use_case.OrgEditEventOutputBoundary;
import org_publish_event_use_case.OrgPublishEventInputBoundary;
import org_publish_event_use_case.OrgPublishEventInteractor;
import org_publish_event_use_case.OrgPublishEventOutputBoundary;
import org_publish_event_use_case.OrgPublishEventResponseModel;
import screens.EventDetailsPage;
import screens.org_home.OrgHomePage;
import screens.org_upcoming_event.OrgDeleteEventController;
import screens.org_upcoming_event.OrgDeleteEventPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OrgUnpublishedEventActionListener implements ActionListener {
    public OrgUnpublishedEventPage orgUnpublishedEventPage;


    public OrgUnpublishedEventActionListener(OrgUnpublishedEventPage orgUnpublishedEventPage){
        this.orgUnpublishedEventPage = orgUnpublishedEventPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.orgUnpublishedEventPage.dispose();
            new OrgHomePage(this.orgUnpublishedEventPage.getOrgUsername());
        }
        else if (actionCommand.contains("Delete")) {
            EventDsGateway eventDsGateway = new EventFileUser();

            OrgDsGateway orgDsGateway = new OrgFileUser();

            ParDsGateway parDsGateway = new ParFileUser();

            OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary = new OrgDeleteEventPresenter();

            OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway, orgDsGateway,
                    parDsGateway, orgDeleteEventOutputBoundary);

            OrgDeleteEventController orgDeleteEventController = new OrgDeleteEventController(interactor);

            String eventName = actionCommand.substring(0,actionCommand.length()-6);

            OrgDeleteEventResponseModel responseModel;
            try {
                try {
                    responseModel = orgDeleteEventController.delete(eventName);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, responseModel.getMessage());

            this.orgUnpublishedEventPage.dispose();
            try {
                new OrgUnpublishedEventPage(this.orgUnpublishedEventPage.getOrgUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if (actionCommand.contains("Publish")){
            EventDsGateway eventDsGateway = new EventFileUser();

            OrgPublishEventOutputBoundary orgPublishEventOutputBoundary = new OrgPublishEventPresenter();

            OrgPublishEventInputBoundary interactor = new OrgPublishEventInteractor(eventDsGateway, orgPublishEventOutputBoundary);

            OrgPublishEventController orgPublishEventController = new OrgPublishEventController(interactor);

            String eventName = actionCommand.substring(0,actionCommand.length()-7);

            OrgPublishEventResponseModel responseModel;
            try {
                responseModel = orgPublishEventController.publish(eventName);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, responseModel.getMessage());

            this.orgUnpublishedEventPage.dispose();

            try {
                new OrgUnpublishedEventPage(this.orgUnpublishedEventPage.getOrgUsername());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if (actionCommand.equals("Create An Event")){
            EventDsGateway eventDsGateway = new EventFileUser();

            OrgDsGateway orgDsGateway= new OrgFileUser();

            OrgCreateEventOutputBoundary orgCreateEventOutputBoundary = new OrgCreateEventPresenter();

            OrgCreateEventInputBoundary interactor = new OrgCreateEventInteractor(eventDsGateway, orgDsGateway, orgCreateEventOutputBoundary);

            OrgCreateEventController orgCreateEventController = new OrgCreateEventController(interactor);

            new OrgCreateEventPage(orgCreateEventController, this.orgUnpublishedEventPage);
        }
        else if (actionCommand.contains("Edit")){
            EventDsGateway eventDsGateway = new EventFileUser();

            OrgDsGateway orgDsGateway= new OrgFileUser();

            OrgEditEventOutputBoundary orgEditEventOutputBoundary = new OrgEditEventPresenter();

            OrgEditEventInputBoundary interactor = new OrgEditEventInteractor(eventDsGateway, orgDsGateway, orgEditEventOutputBoundary);

            OrgEditEventController orgEditEventController = new OrgEditEventController(interactor);

            String eventName = actionCommand.substring(0,actionCommand.length()-4);

            try {
                new OrgEditEventPage(orgEditEventController, this.orgUnpublishedEventPage, eventName, eventDsGateway);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                new EventDetailsPage(actionCommand);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
