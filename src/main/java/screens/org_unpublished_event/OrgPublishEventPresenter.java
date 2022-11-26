package screens.org_unpublished_event;

import org_publish_event_use_case.OrgPublishEventOutputBoundary;
import org_publish_event_use_case.OrgPublishEventResponseModel;
import screens.ShowMessageView;

public class OrgPublishEventPresenter implements OrgPublishEventOutputBoundary {
    @Override
    public OrgPublishEventResponseModel prepareSuccessView(OrgPublishEventResponseModel response) {
        //Generate the message to be shown on the success view
        response.setMessage("Event " + response.getEventName() + " is published!");
        return response;
    }
    @Override
    public OrgPublishEventResponseModel prepareFailView(String error) {
        //Prepare a failed view
        throw new ShowMessageView(error);
    }
}
