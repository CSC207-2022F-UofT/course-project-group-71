package screens.org_unpublished_event;

import org_publish_event_use_case.OrgPublishEventOutputBoundary;
import org_publish_event_use_case.OrgPublishEventResponseModel;

public class OrgPublishEventPresenter implements OrgPublishEventOutputBoundary {
    @Override
    public OrgPublishEventResponseModel prepareSuccessView(OrgPublishEventResponseModel response) {
        //Generate the message to be shown on the success view
        response.setMessage("Event " + response.getEventName() + " is published!");
        return response;
    }

}
