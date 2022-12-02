package use_cases.org_delete_event_use_case;

import database.EventDsGateway;
import database.ParDsGateway;

import java.util.ArrayList;

public class OrgDeleteEventInteractor implements OrgDeleteEventInputBoundary {

    final EventDsGateway eventDsGateway;
    final ParDsGateway parDsGateway;
    final OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary;

    /**Constructor
     *
     * @param eventDsGateway The database gateway of the events
     * @param parDsGateway The database gateway of the participants
     * @param orgDeleteEventOutputBoundary The OutputBoundary used to show success of deletion
     */
    public OrgDeleteEventInteractor(EventDsGateway eventDsGateway,
                                    ParDsGateway parDsGateway,
                                    OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary) {
        this.eventDsGateway = eventDsGateway;
        this.parDsGateway = parDsGateway;
        this.orgDeleteEventOutputBoundary = orgDeleteEventOutputBoundary;
    }

    /**Use the information contained in the orgDeleteEventRequestModel to delete an event and return a responseModel.
     * It retrieves orgUsername, parUsernames via eventName.
     * It deletes all possible associated events for org in database: OrgPastEvent, OrgUnpublishedEvent, OrgUpcomingEvent.
     * If parUsernames non-empty, it deletes all possible associated events for pars in database: ParPastEvent, ParUpcomingEvent,
     and add a notification to all participants.
     * Success response is returned.
     *
     * @param orgDeleteEventRequestModel The request model sent to the interactor
     * @return orgDeleteEventResponseModel representing whether event deletion is successful
     */
    @Override
    public OrgDeleteEventResponseModel delete(OrgDeleteEventRequestModel orgDeleteEventRequestModel) throws ClassNotFoundException {
        //deletes the event from the database
        String eventName = orgDeleteEventRequestModel.getEventName();
        eventDsGateway.deleteEvent(eventName);

        //send out notification to all participants that joined the event
        ArrayList<String> parUsernames = eventDsGateway.getParticipants(eventName);
        System.out.println(parUsernames.get(0)+" correct");
        String newNotification = "Event " + eventName + " is cancelled.";
        if (!parUsernames.isEmpty()) {
            for (String username : parUsernames) {
                parDsGateway.leaveEvent(username, eventName);
                parDsGateway.addNotification(username, newNotification);
                System.out.println("i am here");
            }
        }

        OrgDeleteEventResponseModel orgDeleteEventResponseModel = new OrgDeleteEventResponseModel(eventName);
        return orgDeleteEventOutputBoundary.prepareSuccessView(orgDeleteEventResponseModel);
    }
}
