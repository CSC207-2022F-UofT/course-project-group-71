package org_publish_event_use_case;

import database.EventDsGateway;
import database.OrgDsGateway;
import database.ParDsGateway;

public class OrgPublishEventInteractor implements OrgPublishEventInputBoundary {
    private EventDsGateway eventDsGateway;
    private OrgDsGateway orgDsGateway;
    private ParDsGateway parDsGateway;
    private OrgPublishEventPresenter orgPublishEventPresenter;
    public OrgPublishEventInteractor(EventDsGateway eventDsGateway, OrgDsGateway orgDsGateway, ParDsGateway parDsGateway, OrgPublishEventPresenter orgPublishEventPresenter) {
        this.eventDsGateway=eventDsGateway;
        this.orgDsGateway=orgDsGateway;
        this.parDsGateway=parDsGateway;
        this.orgPublishEventPresenter=orgPublishEventPresenter;
    }

    @Override
    public OrgPublishEventResponseModel publish(OrgPublishEventRequestModel requestModel) {
        String eventName = requestModel.getEventName();
        String orgUsername = eventDsGateway.getOrganization(eventName);


        eventDsGateway.ChangeToUpcoming(eventName);

        OrgPublishEventResponseModel orgPublishEventResponseModel = new OrgPublishEventResponseModel(eventName);
        return orgPublishEventPresenter.prepareSuccessView(orgPublishEventResponseModel);
    }
}
