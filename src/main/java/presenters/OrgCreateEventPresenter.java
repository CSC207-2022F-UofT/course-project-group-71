package presenters;

import use_cases.org_create_event_use_case.OrgCreateEventResponseModel;
import screens.common_view.ShowMessageView;
import use_cases.org_create_event_use_case.OrgCreateEventOutputBoundary;

public class OrgCreateEventPresenter implements OrgCreateEventOutputBoundary {

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
