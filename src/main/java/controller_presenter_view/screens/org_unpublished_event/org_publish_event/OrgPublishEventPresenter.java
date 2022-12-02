package controller_presenter_view.screens.org_unpublished_event.org_publish_event;

import use_cases.org_publish_event_use_case.OrgPublishEventOutputBoundary;
import use_cases.org_publish_event_use_case.OrgPublishEventResponseModel;
import controller_presenter_view.common_view.ShowMessageView;

public class OrgPublishEventPresenter implements OrgPublishEventOutputBoundary {
    @Override
    public OrgPublishEventResponseModel prepareSuccessView(OrgPublishEventResponseModel response) {
        //Generate the message to be shown on the success view
        if (response.getHasFollower()){
            response.setMessage("Event " + response.getEventName() + " is published! Your followers are notified.");
        } else {
            response.setMessage("Event " + response.getEventName() + " is published!");
        }
        return response;
    }
    @Override
    public OrgPublishEventResponseModel prepareFailView(String error) {
        //Prepare a failed view
        throw new ShowMessageView(error);
    }
}
