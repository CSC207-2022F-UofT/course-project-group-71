package org_publish_event_use_case;

import database.EventDsGateway;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrgPublishEventInteractor implements OrgPublishEventInputBoundary {

    EventDsGateway eventDsGateway;
    OrgPublishEventOutputBoundary orgPublishEventOutputBoundary;

    /**Constructor
     *
     * @param eventDsGateway The database gateway of the events
     * @param orgPublishEventOutputBoundary The OutputBoundary used to show success of publishing
     */
    public OrgPublishEventInteractor(EventDsGateway eventDsGateway, OrgPublishEventOutputBoundary orgPublishEventOutputBoundary) {
        this.eventDsGateway = eventDsGateway;
        this.orgPublishEventOutputBoundary = orgPublishEventOutputBoundary;
    }

    /**Use the provided method in eventDsGateway to publish an event.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the event publishing is successful
     */
    @Override
    public OrgPublishEventResponseModel publish(OrgPublishEventRequestModel requestModel) throws SQLException, ClassNotFoundException {

        ArrayList<Integer> times = eventDsGateway.getTime(requestModel.eventName);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = LocalDateTime.of(times.get(0), times.get(1), times.get(2), times.get(3), times.get(4));

        //checks if the time is set in the future.
        if (time.isBefore(now)){
            return orgPublishEventOutputBoundary.prepareFailView("Time must be in future, please edit the time.");
        }

        eventDsGateway.unPublishedToUpcoming(requestModel.getEventName());
        OrgPublishEventResponseModel orgPublishEventResponseModel =
                new OrgPublishEventResponseModel(requestModel.getEventName());
        return orgPublishEventOutputBoundary.prepareSuccessView(orgPublishEventResponseModel);
    }
}
