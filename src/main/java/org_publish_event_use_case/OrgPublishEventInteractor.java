package org_publish_event_use_case;

import database.EventDsGateway;

import java.sql.SQLException;

public class OrgPublishEventInteractor implements OrgPublishEventInputBoundary {
    private EventDsGateway eventDsGateway;
    private OrgPublishEventOutputBoundary orgPublishEventOutputBoundary;

    /**This is the construct method of OrgPublishEventInteractor.
     * It takes DsGateways and OutputBoundary as input to store as instances.
     *
     * @param eventDsGateway The database gateway of the events
     * @param orgPublishEventOutputBoundary The OutputBoundary used to show success of publishing
     */
    public OrgPublishEventInteractor(EventDsGateway eventDsGateway, OrgPublishEventOutputBoundary orgPublishEventOutputBoundary) {
        this.eventDsGateway = eventDsGateway;
        this.orgPublishEventOutputBoundary = orgPublishEventOutputBoundary;
    }

    /**Use the information contained in the requestmodel to publish an event and respond a responsemodel.
     * It retrieves an event name.
     * It publishes the event.
     * Success response is returned.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responsemodel representing whether the event publishing is successful
     */
    @Override
    public OrgPublishEventResponseModel publish(OrgPublishEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        String eventName = requestModel.getEventName();
        System.out.println(eventName);

        eventDsGateway.unPublishedToUpcoming(eventName);
        System.out.println("B");
        OrgPublishEventResponseModel orgPublishEventResponseModel = new OrgPublishEventResponseModel(eventName);

        return orgPublishEventOutputBoundary.prepareSuccessView(orgPublishEventResponseModel);
    }
}
