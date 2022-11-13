package event_create_use_case;

// TODO: Remove dependencies on EventFileUser
import database.EventDsGateway;
import database.EventFileUser;

public class EventCreateInteractor implements EventCreateInputBoundary {

    // TODO: Change to EventDsGateway
    final EventFileUser eventDsGateway;
    final EventCreateOutputBoundary userOutput;

    public EventCreateInteractor(EventFileUser eventDsGateway,
                                 EventCreateOutputBoundary userOutput) {
        this.eventDsGateway = eventDsGateway;
        this.userOutput = userOutput;
    }

    @Override
    public EventCreateResponseModel create(EventCreateRequestModel requestModel) {
        if (eventDsGateway.checkIfEventNameExists(requestModel.getTitle())) {
            return userOutput.prepareFailView("Title already exists.");
        }
        eventDsGateway.utilStoreEvent(requestModel.getTitle(), requestModel.getStatus(), requestModel.getEventType(),
                requestModel.getDescription(), requestModel.getLocation(), requestModel.getImagePath(),
                requestModel.getYear(), requestModel.getMonth(), requestModel.getDay(), requestModel.getHour(),
                requestModel.getMinute());
        EventCreateResponseModel responseModel = new EventCreateResponseModel(requestModel.getTitle(),
                requestModel.getStatus(), requestModel.getEventType(), requestModel.getDescription(),
                requestModel.getLocation(), requestModel.getImagePath(), requestModel.getYear(),
                requestModel.getMonth(), requestModel.getDay(), requestModel.getHour(), requestModel.getMinute());
        return userOutput.prepareSuccessView(responseModel);
    }
}
