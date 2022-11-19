package org_delete_event_use_case;

import database.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrgDeleteEventInteractor implements OrgDeleteEventInputBoundary {

    final EventDsGateway eventDsGateway;
    final OrgDsGateway orgDsGateway;
    final ParDsGateway parDsGateway;
    final OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary;

    /**This is the construct method of OrgDeleteEventInteractor.
     * It takes DsGateways and OutputBoundary as input to store as instances.
     *
     * @param eventDsGateway The database gateway of the events
     * @param orgDsGateway The database gateway of the organizers
     * @param parDsGateway The database gateway of the participants
     * @param orgDeleteEventOutputBoundary The OutputBoundary used to show success of deletion
     */

    public OrgDeleteEventInteractor(EventDsGateway eventDsGateway,
                                    OrgDsGateway orgDsGateway,
                                    ParDsGateway parDsGateway,
                                    OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
        this.orgDeleteEventOutputBoundary = orgDeleteEventOutputBoundary;
    }

    /**Use the information contained in the orgDeleteEventRequestModel to delete an event and create a responsemodel.
     * It retrieves orgUsername, parUsernames via eventName.
     * It deletes all possible associated events for org in database: OrgPastEvent, OrgUnpublishedEvent, OrgUpcomingevent.
     * If parUsernames non-empty, it deletes all possible associated events for pars in database: ParPastEvent, ParUpcomingEvent,
     and add a notification to all pars.
     * Success response is returned.
     *
     * @param orgDeleteEventRequestModel The request model sent to the interactor
     * @return orgDeleteEventResponseModel representing whether event deletion is successful
     */
    @Override
    public OrgDeleteEventResponseModel delete(OrgDeleteEventRequestModel orgDeleteEventRequestModel) throws SQLException, ClassNotFoundException {
        String eventName = orgDeleteEventRequestModel.getEventName();
        String orgUsername = eventDsGateway.getOrganization(eventName);
        ArrayList<String> parUsernames = eventDsGateway.getParticipants(eventName);
        String newNotification = "Event " + eventName + " is canceled";

        orgDsGateway.deleteAnEvent(eventName);
        if (!parUsernames.isEmpty()) {
            for (String username : parUsernames) {
                parDsGateway.leaveEvent(username, eventName);//LEAVE BEHAVES THE SAME WAY HERE! BUT WATCH OUT!
                parDsGateway.addNotification(username, newNotification);
            }
        }
        eventDsGateway.deleteEvent(eventName);

        OrgDeleteEventResponseModel orgDeleteEventResponseModel = new OrgDeleteEventResponseModel(eventName);
        return orgDeleteEventOutputBoundary.prepareSuccessView(orgDeleteEventResponseModel);
    }
}
