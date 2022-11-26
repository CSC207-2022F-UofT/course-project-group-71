package org_publish_event_use_case;

import database.EventDsGateway;

import java.sql.SQLException;

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
        eventDsGateway.unPublishedToUpcoming(requestModel.getEventName());
        OrgPublishEventResponseModel orgPublishEventResponseModel =
                new OrgPublishEventResponseModel(requestModel.getEventName());
        return orgPublishEventOutputBoundary.prepareSuccessView(orgPublishEventResponseModel);
    }
}
