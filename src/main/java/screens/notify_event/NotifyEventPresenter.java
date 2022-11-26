package screens.notify_event;

import notify_event_use_case.NotifyEventOutputBoundary;
import notify_event_use_case.NotifyEventResponseModel;
import screens.ShowMessageView;

public class NotifyEventPresenter implements NotifyEventOutputBoundary {
    @Override
    public NotifyEventResponseModel prepareSuccessView(NotifyEventResponseModel response) {
        if (response.getNotificationType().equals("Future")){
            response.setMessage("Notification sent for " + response.getEventName() + "!");
        } else if (response.getNotificationType().equals("Past")){
            response.setMessage("Event " + response.getEventName() + " was over.");
        }
        return response;
    }


    @Override
    public NotifyEventResponseModel prepareFailView(NotifyEventResponseModel response) {
        response.setMessage("No participant has registered up for " + response.getEventName() + "!");
        throw new ShowMessageView(response.getMessage());
    }
}
