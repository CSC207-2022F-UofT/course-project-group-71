package org_notify_event_use_case;

import database.*;

import java.sql.SQLException;
import java.util.*;

public class OrgNotifyEventInteractor implements OrgNotifyEventInputBoundary {


    private EventDsGateway eventDsGateway;

    private ParDsGateway parDsGateway;
    private OrgNotifyEventPresenter orgNotifyEventPresenter;

    public OrgNotifyEventInteractor(EventDsGateway eventDsGateway,
                                    ParDsGateway parDsGateway,
                                    OrgNotifyEventPresenter orgNotifyEventPresenter) {
        this.eventDsGateway = eventDsGateway;
        this.parDsGateway = parDsGateway;
        this.orgNotifyEventPresenter = orgNotifyEventPresenter;
    }

    @Override
    public OrgNotifyEventResponseModel sendNotification (OrgNotifyEventRequestModel orgNotifyEventRequestModel) throws SQLException, ClassNotFoundException {
        String eventName = orgNotifyEventRequestModel.getEventName();
        ArrayList<String> parUsernames = eventDsGateway.getParticipants(eventName);
        OrgNotifyEventResponseModel notificationResponseModel =
                new OrgNotifyEventResponseModel(eventName);
        if (parUsernames.isEmpty()) {
            return orgNotifyEventPresenter.prepareFailView(notificationResponseModel);
        }

        ArrayList<Integer> times = eventDsGateway.getTime(eventName);
        String time = times.get(1) + "-" + times.get(2) + " " + times.get(3) + ":" + times.get(4);
        for (String username : parUsernames) {
            String newNotification = "";
            if (orgNotifyEventRequestModel.getNotificationType().equals("Future")){
                newNotification = "Event " + eventName + " is about to happen at " + time + "!";
            } else {
                newNotification = "Event " + eventName + " was over at " + time + ".";
            }
            parDsGateway.addNotification(username, newNotification);

        }
        return orgNotifyEventPresenter.prepareSuccessView(notificationResponseModel);
    }

}