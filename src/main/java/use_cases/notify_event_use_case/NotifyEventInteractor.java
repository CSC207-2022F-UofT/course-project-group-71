package use_cases.notify_event_use_case;

import database.*;

import java.util.*;

public class NotifyEventInteractor implements NotifyEventInputBoundary {

    final EventDsGateway eventDsGateway;
    final ParDsGateway parDsGateway;
    final NotifyEventOutputBoundary notifyEventOutputBoundary;

    /**Constructor
     *
     * @param eventDsGateway The database gateway of the events
     * @param parDsGateway The database gateway of the participants
     * @param notifyEventOutputBoundary The OutputBoundary used to show success or not of notification
     */
    public NotifyEventInteractor(EventDsGateway eventDsGateway,
                                 ParDsGateway parDsGateway,
                                 NotifyEventOutputBoundary notifyEventOutputBoundary) {
        this.eventDsGateway = eventDsGateway;
        this.parDsGateway = parDsGateway;
        this.notifyEventOutputBoundary = notifyEventOutputBoundary;
    }

    /**Send notification to participant, content depending on different status of the event.
     * Note: This method could be triggered in two cases. One is an organization clicks the "Notify" button on the
     *      upcoming event page, notificationType would be "Future". The other one is that the system recognizes
     *      the event has already happened, notificationType would be "Past". The latter case can be seen in OrgHomePage.
     *
     * @param notifyEventRequestModel The request model sent to interact
     * @return A responseModel representing whether the notification is successful
     */
    @Override
    public NotifyEventResponseModel sendNotification(NotifyEventRequestModel notifyEventRequestModel) throws ClassNotFoundException {
        String eventName = notifyEventRequestModel.getEventName();
        String notificationType = notifyEventRequestModel.getNotificationType();
        ArrayList<String> parUsernames = eventDsGateway.getParticipants(eventName);
        NotifyEventResponseModel notificationResponseModel =
                new NotifyEventResponseModel(eventName, notificationType);

        //if no participant joined the event, no notification will be added to participant's database
        if (parUsernames.isEmpty()) {
            if (notificationType.equals("Future")) {
                return notifyEventOutputBoundary.prepareFailView(notificationResponseModel);
            }
            else {//notificationType is "Past"
                return notifyEventOutputBoundary.prepareSuccessView(notificationResponseModel);
            }
        }

        //sends out notification to all participants
        ArrayList<Integer> times = eventDsGateway.getTime(eventName);
        String time = times.get(1) + "-" + times.get(2) + " " + times.get(3) + ":" + times.get(4);
        for (String username : parUsernames) {
            String newNotification;
            if (notificationType.equals("Future")){
                newNotification = "Event " + eventName + " is about to happen at " + time + "!";
            } else {//notificationType is "Past"
                newNotification = "Event " + eventName + " was over at " + time + ".";
            }
            parDsGateway.addNotification(username, newNotification);
        }
        return notifyEventOutputBoundary.prepareSuccessView(notificationResponseModel);
    }

}