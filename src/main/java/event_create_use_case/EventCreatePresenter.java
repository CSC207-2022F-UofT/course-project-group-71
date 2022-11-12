package event_create_use_case;

import screens.EventCreateViewModel;

import screens.EventCreationFailed;

// TODO: Implement a view model
public class EventCreatePresenter implements EventCreateOutputBoundary {

    final EventCreateViewModel viewModel;

    public EventCreatePresenter(EventCreateViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public EventCreateResponseModel prepareSuccessView(EventCreateResponseModel responseModel) {
        // TODO: What exactly needs to be returned here? Is it really the response model?
        this.viewModel.setSuccessMessage(responseModel.getTitle());
        return responseModel;
    }

    @Override
    public EventCreateResponseModel prepareFailView(String error) {
        throw new EventCreationFailed(error);
    }
}
