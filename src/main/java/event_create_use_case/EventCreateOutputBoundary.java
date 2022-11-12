package event_create_use_case;

public interface EventCreateOutputBoundary {
    void prepareSuccessView(EventCreateResponseModel responseModel);

    void prepareFailView(String error);
}
