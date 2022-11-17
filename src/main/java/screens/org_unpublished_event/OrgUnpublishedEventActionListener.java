package screens.org_unpublished_event;

import database.*;
import org_create_event_use_case.OrgCreateEventInputBoundary;
import org_create_event_use_case.OrgCreateEventInteractor;
import org_create_event_use_case.OrgCreateEventPresenter;
import org_delete_event_use_case.OrgDeleteEventInputBoundary;
import org_delete_event_use_case.OrgDeleteEventInteractor;
import org_delete_event_use_case.OrgDeleteEventPresenter;
import org_delete_event_use_case.OrgDeleteEventResponseModel;
import org_publish_event_use_case.*;
import screens.org_home.OrgHomePage;
import screens.org_upcoming_event.OrgDeleteEventController;
import screens.org_upcoming_event.OrgDeleteEventResponseFormatter;
import screens.org_upcoming_event.OrgUpcomingEventPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            OrgDeleteEventPresenter orgDeleteEventPresenter = new OrgDeleteEventResponseFormatter();

            OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway, orgDsGateway,
                    parDsGateway,orgDeleteEventPresenter);

            OrgDeleteEventController orgDeleteEventController = new OrgDeleteEventController(interactor);

            String eventName = actionCommand.substring(0,actionCommand.length()-6);

            try{
                OrgDeleteEventResponseModel responseModel = orgDeleteEventController.delete(eventName);
                JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, responseModel.getMessage());
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, e.getMessage());
            }
            this.orgUnpublishedEventPage.dispose();
            new OrgUpcomingEventPage(this.orgUnpublishedEventPage.getOrgUsername());
        }
        else if (actionCommand.contains("Publish")){
            EventDsGateway eventDsGateway = new EventFileUser();

            OrgDsGateway orgDsGateway = new OrgFileUser();

            ParDsGateway parDsGateway = new ParFileUser();

            OrgPublishEventPresenter orgPublishEventPresenter = new OrgPublishEventResponseFormatter();

            OrgPublishEventInputBoundary interactor = new OrgPublishEventInteractor(eventDsGateway, orgDsGateway,
                    parDsGateway,orgPublishEventPresenter);

            OrgPublishEventController orgPublishEventController = new OrgPublishEventController(interactor);
            System.out.println((actionCommand.substring(0)));
            String eventName = actionCommand.substring(0,actionCommand.length()-7);
            System.out.println(eventName + "A");

            try{
                OrgPublishEventResponseModel responseModel = orgPublishEventController.publish(eventName);
                JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, responseModel.getMessage());
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this.orgUnpublishedEventPage, e.getMessage());
            }
            this.orgUnpublishedEventPage.dispose();
            new OrgUnpublishedEventPage(this.orgUnpublishedEventPage.getOrgUsername());

        }
        else if (actionCommand.contains("Create")){
            EventDsGateway eventDsGateway = new EventFileUser();

            OrgDsGateway orgDsGateway= new OrgFileUser();

            OrgCreateEventPresenter orgCreateEventPresenter = new OrgCreateEventResponseFormatter();

            OrgCreateEventInputBoundary interactor = new OrgCreateEventInteractor(eventDsGateway, orgDsGateway, orgCreateEventPresenter);

            OrgCreateEventController orgCreateEventController = new OrgCreateEventController(interactor);

            new CreateEventPage(orgCreateEventController);
        }
    }
}
