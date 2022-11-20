package screens.org_upcoming_event;

import org_notify_event_use_case.OrgNotifyEventOutputBoundary;
import org_notify_event_use_case.OrgNotifyEventResponseModel;
import screens.ShowMessageView;

public class OrgNotifyEventPresenter implements OrgNotifyEventOutputBoundary {
    @Override
    public OrgNotifyEventResponseModel prepareSuccessView(OrgNotifyEventResponseModel response) {
        if (response.getNotificationType().equals("Future")){
            response.setMessage("Notification sent for " + response.getEventName() + "!");
        } else if (response.getNotificationType().equals("Past")){
            response.setMessage("Event " + response.getEventName() + " was over.");
        }
        return response;
    }


    @Override
    public OrgNotifyEventResponseModel prepareFailView(OrgNotifyEventResponseModel response) {
        response.setMessage("No participant has registered up for " + response.getEventName() + "!");
        System.out.println(response.getMessage());
        throw new ShowMessageView(response.getMessage());
    }
}
