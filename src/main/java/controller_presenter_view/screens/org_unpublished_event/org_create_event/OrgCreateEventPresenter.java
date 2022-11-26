package controller_presenter_view.screens.org_unpublished_event.org_create_event;

import org_create_event_use_case.OrgCreateEventResponseModel;
import controller_presenter_view.common_view.ShowMessageView;

public class OrgCreateEventPresenter implements org_create_event_use_case.OrgCreateEventOutputBoundary {

    @Override
    public OrgCreateEventResponseModel prepareSuccessView(OrgCreateEventResponseModel response) {
        //Prepare a success view
        response.setMessage("Event " + response.getTitle() + " is successfully created!");
        System.out.println(1);
        return response;
    }

    @Override
    public OrgCreateEventResponseModel prepareFailView(String error) {
        //Prepare a failed view
        throw new ShowMessageView(error);
    }
}
