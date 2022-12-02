package controller_presenter_view.screens.org_unpublished_event;

import controller_presenter_view.common_controller_presenter.org_delete_event.OrgDeleteEventController;
import controller_presenter_view.common_view.EventDetailsPage;
import controller_presenter_view.screens.org_home.OrgHomePage;
import controller_presenter_view.screens.org_unpublished_event.org_create_event.OrgCreateEventController;
import controller_presenter_view.screens.org_unpublished_event.org_create_event.OrgCreateEventPage;
import controller_presenter_view.screens.org_unpublished_event.org_create_event.OrgCreateEventPresenter;
import controller_presenter_view.screens.org_unpublished_event.org_edit_event.OrgEditEventController;
import controller_presenter_view.screens.org_unpublished_event.org_edit_event.OrgEditEventPage;
import controller_presenter_view.screens.org_unpublished_event.org_edit_event.OrgEditEventPresenter;
import controller_presenter_view.screens.org_unpublished_event.org_publish_event.OrgPublishEventController;
import controller_presenter_view.screens.org_unpublished_event.org_publish_event.OrgPublishEventPresenter;
import database.*;
import controller_presenter_view.screens.Util_Method;
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
    final OrgUnpublishedEventPage orgUnpublishedEventPage;

    public OrgUnpublishedEventActionListener(OrgUnpublishedEventPage orgUnpublishedEventPage){
        this.orgUnpublishedEventPage = orgUnpublishedEventPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();
        String orgUsername = this.orgUnpublishedEventPage.getOrgUsername();

        if (actionCommand.equals("Back")) {
            this.orgUnpublishedEventPage.dispose();
            new OrgHomePage(orgUsername);
        }
        else if (actionCommand.contains("Delete")) {
            OrgDeleteEventController orgDeleteEventController = Util_Method.utilGetDeleteEventControllerHelper();
            String eventName = actionCommand.substring(0,actionCommand.length()-6);
            OrgDeleteEventResponseModel responseModel;
            try {
                responseModel = orgDeleteEventController.delete(eventName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, responseModel.getMessage());
            this.orgUnpublishedEventPage.dispose();
            try {
                new OrgUnpublishedEventPage(orgUsername);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if (actionCommand.contains("Publish")){
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
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, e.getMessage());
            }
            this.orgUnpublishedEventPage.dispose();
            try {
                new OrgUnpublishedEventPage(orgUsername);
            } catch (ClassNotFoundException e) {
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
            OrgEditEventInputBoundary interactor = new OrgEditEventInteractor(orgDsGateway, orgEditEventOutputBoundary);
            OrgEditEventController orgEditEventController = new OrgEditEventController(interactor);
            String eventName = actionCommand.substring(0,actionCommand.length()-4);
            try {
                new OrgEditEventPage(orgEditEventController, this.orgUnpublishedEventPage, eventName, eventDsGateway);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {//Generate Event Detail Page
            try {
                new EventDetailsPage(actionCommand);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
