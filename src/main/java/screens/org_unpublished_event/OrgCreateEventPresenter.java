package screens.org_unpublished_event;

import org_create_event_use_case.OrgCreateEventResponseModel;
import screens.ShowMessageView;

public class OrgCreateEventPresenter implements org_create_event_use_case.OrgCreateEventOutputBoundary {

    @Override
    public OrgCreateEventResponseModel prepareSuccessView(OrgCreateEventResponseModel response) {
        response.setMessage("Event " + response.getTitle() + " is successfully created!");
        return response;
    }

    @Override
    public OrgCreateEventResponseModel prepareFailView(String error) {
        throw new ShowMessageView(error);
    }
}
