package screens.org_upcoming_event;

import org_notify_event_use_case.OrgNotifyEventPresenter;
import org_notify_event_use_case.OrgNotifyEventResponseModel;

public class OrgNotifyEventResponseFormatter implements OrgNotifyEventPresenter {
    @Override
    public OrgNotifyEventResponseModel prepareSuccessView(OrgNotifyEventResponseModel response) {
        response.setMessage("Notification sent for" + response.getEventName() + "!");
        return response;
    }

    @Override
    public OrgNotifyEventResponseModel prepareFailView(OrgNotifyEventResponseModel response) {
        response.setMessage("No participant has registered up for " + response.getEventName() + "!");
        return response;
    }
}
