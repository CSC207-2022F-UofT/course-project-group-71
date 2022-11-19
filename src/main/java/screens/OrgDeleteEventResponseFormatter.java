package screens;

import org_delete_event_use_case.OrgDeleteEventResponseModel;
import org_delete_event_use_case.OrgDeleteEventOutputBoundary;

public class OrgDeleteEventResponseFormatter implements OrgDeleteEventOutputBoundary {
    @Override
    public OrgDeleteEventResponseModel prepareSuccessView(OrgDeleteEventResponseModel response) {
        response.setMessage("Event " + response.getEventName() + " deleted");
        return response;
    }
}
