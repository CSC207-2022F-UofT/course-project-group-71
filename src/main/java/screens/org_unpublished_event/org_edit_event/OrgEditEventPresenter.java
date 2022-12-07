package screens.org_unpublished_event.org_edit_event;

import use_cases.org_edit_event_use_case.OrgEditEventOutputBoundary;
import use_cases.org_edit_event_use_case.OrgEditEventResponseModel;
import screens.common_view.ShowMessageView;

public class OrgEditEventPresenter implements OrgEditEventOutputBoundary {

    @Override
    public OrgEditEventResponseModel prepareSuccessView(OrgEditEventResponseModel response) {
        //Set the message which would be used to show the success view
        response.setMessage("Event " + response.getTitle() + " is successfully edited!");
        return response;
    }

    @Override
    public OrgEditEventResponseModel prepareFailView(String error) {
        //Throw the failure message out
        throw new ShowMessageView(error);
    }
}
