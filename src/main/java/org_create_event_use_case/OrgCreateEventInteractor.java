package org_create_event_use_case;

import database.EventDsGateway;
import database.OrgDsGateway;
import screens.org_unpublished_event.OrgCreateEventResponseFormatter;

public class OrgCreateEventInteractor implements OrgCreateEventInputBoundary {

    EventDsGateway eventDsGateway;
    OrgDsGateway orgDsGateway;
    OrgCreateEventPresenter orgCreateEventPresenter;


    public OrgCreateEventInteractor(EventDsGateway eventDsGateway,
                                    OrgDsGateway orgDsGateway,
                                    OrgCreateEventPresenter orgCreateEventPresenter) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.orgCreateEventPresenter = orgCreateEventPresenter;
    }

    @Override
    public OrgCreateEventResponseModel create(OrgCreateEventRequestModel requestModel) {
        if (eventDsGateway.checkIfEventNameExist(requestModel.getTitle())) {
            return orgCreateEventPresenter.prepareFailView("Title already exists.");
        } else {
            orgDsGateway.createAnEvent(requestModel.getOrgUsername(), requestModel.getTitle(), requestModel.getStatus(),
                    requestModel.getDescription(), requestModel.getLocation(),requestModel.getYear(), requestModel.getMonth(), requestModel.getDay(),
                    requestModel.getHour(), requestModel.getMinute());
            OrgCreateEventResponseModel responseModel = new OrgCreateEventResponseModel(requestModel.getOrgUsername(),
                    requestModel.getTitle(), requestModel.getStatus(),
                    requestModel.getDescription(), requestModel.getLocation(),
                    requestModel.getYear(), requestModel.getMonth(), requestModel.getDay(), requestModel.getHour(),
                    requestModel.getMinute());
            return orgCreateEventPresenter.prepareSuccessView(responseModel);

        }
    }
}
