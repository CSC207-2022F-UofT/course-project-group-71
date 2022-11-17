package event_create_use_case;

public interface EventCreateInputBoundary {
    EventCreateResponseModel create(EventCreateRequestModel requestModel);
}
