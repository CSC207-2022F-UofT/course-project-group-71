package event_create_use_case;

import screens.EventCreationFailed;

// TODO: Implement a view model
public class EventCreatePresenter implements EventCreateOutputBoundary {

    @Override
    public EventCreateResponseModel prepareSuccessView(EventCreateResponseModel responseModel) {
        // TODO: What exactly needs to be returned here? Is it really the response model?
        return responseModel;
    }

    @Override
    public EventCreateResponseModel prepareFailView(String error) {
        throw new EventCreationFailed(error);
    }
}
