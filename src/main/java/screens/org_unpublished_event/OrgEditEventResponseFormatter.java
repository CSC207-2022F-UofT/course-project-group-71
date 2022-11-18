package screens.org_unpublished_event;

import org_edit_event_use_case.OrgEditEventPresenter;
import org_edit_event_use_case.OrgEditEventResponseModel;
import screens.ShowMessageView;

public class OrgEditEventResponseFormatter implements OrgEditEventPresenter {

    @Override
    public OrgEditEventResponseModel prepareSuccessView(OrgEditEventResponseModel response) {
        response.setMessage("Event " + response.getTitle() + " is successfully edited!");
        return response;
    }

    @Override
    public OrgEditEventResponseModel prepareFailView(String error) {
        throw new ShowMessageView(error);
    }
}
