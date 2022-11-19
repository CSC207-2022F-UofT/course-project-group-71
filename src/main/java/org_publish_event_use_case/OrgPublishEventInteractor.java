package org_publish_event_use_case;

import database.EventDsGateway;

import java.sql.SQLException;

public class OrgPublishEventInteractor implements OrgPublishEventInputBoundary {
    private EventDsGateway eventDsGateway;
    private OrgPublishEventOutputBoundary orgPublishEventOutputBoundary;
    public OrgPublishEventInteractor(EventDsGateway eventDsGateway, OrgPublishEventOutputBoundary orgPublishEventOutputBoundary) {
        this.eventDsGateway = eventDsGateway;
        this.orgPublishEventOutputBoundary = orgPublishEventOutputBoundary;
    }

    @Override
    public OrgPublishEventResponseModel publish(OrgPublishEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        String eventName = requestModel.getEventName();

        eventDsGateway.unPublishedToUpcoming(eventName);

        OrgPublishEventResponseModel orgPublishEventResponseModel = new OrgPublishEventResponseModel(eventName);

        return orgPublishEventOutputBoundary.prepareSuccessView(orgPublishEventResponseModel);
    }
}
