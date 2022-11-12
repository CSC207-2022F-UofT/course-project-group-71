package event_create_use_case;

import screens.EventCreationFailed;

// TODO: Implement a view model
public class EventCreatePresenter implements EventCreateOutputBoundary {

    @Override
    public void prepareSuccessView(EventCreateResponseModel responseModel) {
        // TODO: What exactly needs to be returned here?
    }

    @Override
    public void prepareFailView(String error) {
        throw new EventCreationFailed(error);
    }
}
