package screens.org_unpublished_event;

import controllers.OrgDeleteEventController;
import screens.common_view.EventDetailsPage;
import screens.org_home.OrgHomePage;
import controllers.OrgCreateEventController;
import screens.org_unpublished_event.org_create_event.OrgCreateEventPage;
import presenters.use_case_presenters.OrgCreateEventPresenter;
import controllers.OrgEditEventController;
import screens.org_unpublished_event.org_edit_event.OrgEditEventPage;
import screens.org_unpublished_event.org_edit_event.OrgEditEventPresenter;
import controllers.OrgPublishEventController;
import screens.org_unpublished_event.org_publish_event.OrgPublishEventPresenter;
import database.*;
import screens.CommonMethod;
import use_cases.org_create_event_use_case.OrgCreateEventInputBoundary;
import use_cases.org_create_event_use_case.OrgCreateEventInteractor;
import use_cases.org_create_event_use_case.OrgCreateEventOutputBoundary;
import use_cases.org_delete_event_use_case.OrgDeleteEventResponseModel;
import use_cases.org_edit_event_use_case.OrgEditEventInputBoundary;
import use_cases.org_edit_event_use_case.OrgEditEventInteractor;
import use_cases.org_edit_event_use_case.OrgEditEventOutputBoundary;
import use_cases.org_publish_event_use_case.OrgPublishEventInputBoundary;
import use_cases.org_publish_event_use_case.OrgPublishEventInteractor;
import use_cases.org_publish_event_use_case.OrgPublishEventOutputBoundary;
import use_cases.org_publish_event_use_case.OrgPublishEventResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgUnpublishedEventActionListener implements ActionListener {
    private final OrgUnpublishedEventPage orgUnpublishedEventPage;

    public OrgUnpublishedEventActionListener(OrgUnpublishedEventPage orgUnpublishedEventPage){
        this.orgUnpublishedEventPage = orgUnpublishedEventPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();
        String orgUsername = this.orgUnpublishedEventPage.getOrgUsername();

        if (actionCommand.equals("Back")) {
            //Back to home page
            this.orgUnpublishedEventPage.dispose();
            new OrgHomePage(orgUsername);
        }
        else if (actionCommand.contains("Delete")) {
            //initialize the controller
            OrgDeleteEventController orgDeleteEventController = CommonMethod.utilGetDeleteEventControllerHelper();
            //delete the event
            String eventName = actionCommand.substring(0,actionCommand.length()-6);
            OrgDeleteEventResponseModel responseModel;
            try {
                responseModel = orgDeleteEventController.delete(eventName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            //show success message
            JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, responseModel.getMessage());
            //renew the unpublished event page
            this.orgUnpublishedEventPage.dispose();
            try {
                new OrgUnpublishedEventPage(orgUsername);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if (actionCommand.contains("Publish")){
            //try to publish the event
            EventDsGateway eventDsGateway = new EventFileUser();
            OrgDsGateway orgDsGateway = new OrgFileUser();
            ParDsGateway parDsGateway = new ParFileUser();
            OrgPublishEventOutputBoundary orgPublishEventOutputBoundary = new OrgPublishEventPresenter();
            OrgPublishEventInputBoundary interactor = new OrgPublishEventInteractor(eventDsGateway, orgDsGateway,
                    parDsGateway, orgPublishEventOutputBoundary);
            OrgPublishEventController orgPublishEventController = new OrgPublishEventController(interactor);
            String eventName = actionCommand.substring(0,actionCommand.length()-7);
            OrgPublishEventResponseModel responseModel;
            try {
                responseModel = orgPublishEventController.publish(eventName, orgUsername);
                JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, responseModel.getMessage());
                //if no exception found, renew the unpublished event page
                this.orgUnpublishedEventPage.dispose();
                try {
                    new OrgUnpublishedEventPage(orgUsername);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (RuntimeException e) {
                //if publish is not successful, show fail message
                JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, e.getMessage());
            }
        }
        else if (actionCommand.equals("Create An Event")){
            //Generate Create Event Page
            EventDsGateway eventDsGateway = new EventFileUser();
            OrgDsGateway orgDsGateway= new OrgFileUser();
            OrgCreateEventOutputBoundary orgCreateEventOutputBoundary = new OrgCreateEventPresenter();
            OrgCreateEventInputBoundary interactor = new OrgCreateEventInteractor(eventDsGateway, orgDsGateway, orgCreateEventOutputBoundary);
            OrgCreateEventController orgCreateEventController = new OrgCreateEventController(interactor);
            new OrgCreateEventPage(orgCreateEventController, this.orgUnpublishedEventPage);
        }
        else if (actionCommand.contains("Edit")){
            //Generate Edit Event Page
            EventDsGateway eventDsGateway = new EventFileUser();
            OrgDsGateway orgDsGateway= new OrgFileUser();
            OrgEditEventOutputBoundary orgEditEventOutputBoundary = new OrgEditEventPresenter();
            OrgEditEventInputBoundary interactor = new OrgEditEventInteractor(orgDsGateway, orgEditEventOutputBoundary);
            OrgEditEventController orgEditEventController = new OrgEditEventController(interactor);
            String eventName = actionCommand.substring(0,actionCommand.length()-4);
            try {
                new OrgEditEventPage(orgEditEventController, this.orgUnpublishedEventPage, eventName, eventDsGateway);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            //Generate Event Detail Page
            try {
                new EventDetailsPage(actionCommand);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
