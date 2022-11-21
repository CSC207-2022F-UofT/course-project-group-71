package screens.org_unpublished_event;

import org_create_event_use_case.OrgCreateEventResponseModel;
import screens.ShowMessageView;

public class OrgCreateEventOutputBoundary implements org_create_event_use_case.OrgCreateEventOutputBoundary {

    @Override
    public OrgCreateEventResponseModel prepareSuccessView(OrgCreateEventResponseModel response) {
        //Prepare a success view
        response.setMessage("Event " + response.getTitle() + " is successfully created!");
        return response;
    }

    @Override
    public OrgCreateEventResponseModel prepareFailView(String error) {
        //Prepare a failed view
        throw new ShowMessageView(error);
    }
}
