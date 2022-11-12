package event_create_use_case;

public interface EventCreateOutputBoundary {
    EventCreateResponseModel prepareSuccessView(EventCreateResponseModel responseModel);

    EventCreateResponseModel prepareFailView(String error);
}
