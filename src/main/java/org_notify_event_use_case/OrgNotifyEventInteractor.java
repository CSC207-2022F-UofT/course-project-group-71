package org_notify_event_use_case;

import database.*;

import java.sql.SQLException;
import java.util.*;

public class OrgNotifyEventInteractor implements OrgNotifyEventInputBoundary {


    private EventDsGateway eventDsGateway;

    private ParDsGateway parDsGateway;
    private OrgNotifyEventOutputBoundary orgNotifyEventOutputBoundary;

    /**This is the construct method of OrgNotifyEventInteractor.
     * It takes DsGateways and OutputBoundary as input to store as instances.
     *
     * @param eventDsGateway The database gateway of the events
     * @param parDsGateway The database gateway of the participants
     * @param orgNotifyEventOutputBoundary The OutputBoundary used to show success or not of notification
     */
    public OrgNotifyEventInteractor(EventDsGateway eventDsGateway,
                                    ParDsGateway parDsGateway,
                                    OrgNotifyEventOutputBoundary orgNotifyEventOutputBoundary) {
        this.eventDsGateway = eventDsGateway;
        this.parDsGateway = parDsGateway;
        this.orgNotifyEventOutputBoundary = orgNotifyEventOutputBoundary;
    }

    /**Use the information contained in the requestmodel to send notifications and respond a responsemodel.
     * It retrieves the event name.
     * It retrieves all participants that joined this event.
     * If participants is empty, return a failure response.
     * Otherwise, send out a notification, success response is returned.
     *
     * @param orgNotifyEventRequestModel The request model sent to the interactor
     * @return A responsemodel representing whether the notification is successful
     */
    @Override
    public OrgNotifyEventResponseModel sendNotification (OrgNotifyEventRequestModel orgNotifyEventRequestModel) throws SQLException, ClassNotFoundException {
        String eventName = orgNotifyEventRequestModel.getEventName();
        String notificationType = orgNotifyEventRequestModel.getNotificationType();
        ArrayList<String> parUsernames = eventDsGateway.getParticipants(eventName);
        OrgNotifyEventResponseModel notificationResponseModel =
                new OrgNotifyEventResponseModel(eventName, notificationType);
        if (parUsernames.isEmpty()) {
            return orgNotifyEventOutputBoundary.prepareFailView(notificationResponseModel);
        }
        ArrayList<Integer> times = eventDsGateway.getTime(eventName);
        String time = times.get(1) + "-" + times.get(2) + " " + times.get(3) + ":" + times.get(4);
        for (String username : parUsernames) {
            String newNotification = null;
            if (notificationType.equals("Future")){
                newNotification = "Event " + eventName + " is about to happen at " + time + "!";
            } else {
                newNotification = "Event " + eventName + " was over at " + time + ".";
            }
            parDsGateway.addNotification(username, newNotification);
        }
        return orgNotifyEventOutputBoundary.prepareSuccessView(notificationResponseModel);
    }

}