package org_delete_use_case;

import database.*;

import java.util.ArrayList;

public class EventDeleteInteractor implements EventDeleteInputBoundary {

    private EventDsGateway eventDsGateway;
    private OrgDsGateway orgDsGateway;
    private ParDsGateway parDsGateway;
    private EventDeletePresenter eventDeletePresenter;

    public EventDeleteInteractor(EventDsGateway eventDsGateway,
                                 OrgDsGateway orgDsGateway,
                                 ParDsGateway parDsGateway,
                                 EventDeletePresenter eventDeletePresenter) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
        this.eventDeletePresenter = eventDeletePresenter;
    }

    @Override
    public EventDeleteResponseModel delete(EventDeleteRequestModel eventDeleteRequestModel) {
        String eventName = eventDeleteRequestModel.getEventName();
        String orgUsername = eventDsGateway.getOrganization(eventName);
        ArrayList<String> parUsernames = eventDsGateway.getParticipants(eventName);
        String newNotification = "Event " + eventName + " is canceled";

        if (!parUsernames.isEmpty()) {
            for (String username : parUsernames) {
                parDsGateway.leaveEvent(username, eventName);//LEAVE BEHAVES THE SAME WAY HERE! BUT WATCH OUT!
                parDsGateway.setNotification(username, newNotification);
            }
        }
        orgDsGateway.deleteAnEvent(orgUsername, eventName);
        eventDsGateway.deleteEvent(eventName);

        EventDeleteResponseModel eventDeleteResponseModel = new EventDeleteResponseModel(eventName);
        return eventDeletePresenter.prepareSuccessView(eventDeleteResponseModel);
    }
}
