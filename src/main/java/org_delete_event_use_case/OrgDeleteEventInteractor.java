package org_delete_event_use_case;

import database.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrgDeleteEventInteractor implements OrgDeleteEventInputBoundary {

    private EventDsGateway eventDsGateway;
    private OrgDsGateway orgDsGateway;
    private ParDsGateway parDsGateway;
    private OrgDeleteEventPresenter orgDeleteEventPresenter;

    public OrgDeleteEventInteractor(EventDsGateway eventDsGateway,
                                 OrgDsGateway orgDsGateway,
                                 ParDsGateway parDsGateway,
                                 OrgDeleteEventPresenter orgDeleteEventPresenter) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
        this.orgDeleteEventPresenter = orgDeleteEventPresenter;
    }

    @Override
    public OrgDeleteEventResponseModel delete(OrgDeleteEventRequestModel orgDeleteEventRequestModel) throws SQLException, ClassNotFoundException {
        String eventName = orgDeleteEventRequestModel.getEventName();
        String orgUsername = eventDsGateway.getOrganization(eventName);
        ArrayList<String> parUsernames = eventDsGateway.getParticipants(eventName);
        String newNotification = "Event " + eventName + " is canceled.";

        if (!parUsernames.isEmpty()) {
            for (String username : parUsernames) {
                parDsGateway.leaveEvent(username, eventName);//LEAVE BEHAVES THE SAME WAY HERE! BUT WATCH OUT!
                parDsGateway.addNotification(username, newNotification);
            }
        }
        orgDsGateway.deleteAnEvent(orgUsername, eventName);
        eventDsGateway.deleteEvent(eventName);

        OrgDeleteEventResponseModel orgDeleteEventResponseModel = new OrgDeleteEventResponseModel(eventName);
        return orgDeleteEventPresenter.prepareSuccessView(orgDeleteEventResponseModel);
    }
}