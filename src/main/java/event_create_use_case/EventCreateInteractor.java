package event_create_use_case;

import database.EventDsGateway;
import database.OrgDsGateway;

public class EventCreateInteractor implements EventCreateInputBoundary {

    final EventDsGateway eventDsGateway;
    final OrgDsGateway orgDsGateway;
    final EventCreateOutputBoundary userOutput;

    public EventCreateInteractor(EventDsGateway eventDsGateway,
                                 OrgDsGateway orgDsGateway,
                                 EventCreateOutputBoundary userOutput) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.userOutput = userOutput;
    }

    @Override
    public void create(EventCreateRequestModel requestModel) {
        if (eventDsGateway.checkIfEventNameExists(requestModel.getTitle())) {
            userOutput.prepareFailView("Title already exists.");
        } else {
            orgDsGateway.createAnEvent(requestModel.getOrgUsername(), requestModel.getTitle(), requestModel.getStatus(),
                    requestModel.getEventType(), requestModel.getDescription(), requestModel.getLocation(),
                    requestModel.getImagePath(), requestModel.getYear(), requestModel.getMonth(), requestModel.getDay(),
                    requestModel.getHour(), requestModel.getMinute());
            EventCreateResponseModel responseModel = new EventCreateResponseModel(requestModel.getOrgUsername(),
                    requestModel.getTitle(), requestModel.getStatus(), requestModel.getEventType(),
                    requestModel.getDescription(), requestModel.getLocation(), requestModel.getImagePath(),
                    requestModel.getYear(), requestModel.getMonth(), requestModel.getDay(), requestModel.getHour(),
                    requestModel.getMinute());
            userOutput.prepareSuccessView(responseModel);

        }
    }
}
