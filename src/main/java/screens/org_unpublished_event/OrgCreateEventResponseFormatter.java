package screens.org_unpublished_event;

import org_create_event_use_case.OrgCreateEventPresenter;
import org_create_event_use_case.OrgCreateEventResponseModel;
import screens.ShowMessageView;

public class OrgCreateEventResponseFormatter implements OrgCreateEventPresenter {

    @Override
    public OrgCreateEventResponseModel prepareSuccessView(OrgCreateEventResponseModel response) {
        response.setMessage("Event " + response.getTitle() + " is successfully created!");
        System.out.println("Formatter returned");
        throw new ShowMessageView(response.getMessage());
    }

    @Override
    public OrgCreateEventResponseModel prepareFailView(String error) {
        throw new ShowMessageView(error);
    }
}
