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
    public void prepareSuccessView(EventCreateResponseModel responseModel) {
        this.viewModel.setSuccessMessage(responseModel.getTitle());
    }

    @Override
    public void prepareFailView(String error) {
        throw new EventCreationFailed(error);
    }
}
