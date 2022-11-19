package screens.org_upcoming_event;

import org_delete_event_use_case.*;

public class OrgDeleteEventPresenter implements OrgDeleteEventOutputBoundary {
    @Override
    public OrgDeleteEventResponseModel prepareSuccessView(OrgDeleteEventResponseModel response) {
        response.setMessage("Event " + response.getEventName() + " is deleted.");
        return response;
    }
}
