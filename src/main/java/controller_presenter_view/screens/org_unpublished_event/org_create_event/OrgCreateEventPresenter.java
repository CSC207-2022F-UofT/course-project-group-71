package controller_presenter_view.screens.org_unpublished_event.org_create_event;

import use_cases.org_create_event_use_case.OrgCreateEventResponseModel;
import controller_presenter_view.common_view.ShowMessageView;
import use_cases.org_create_event_use_case.OrgCreateEventOutputBoundary;

public class OrgCreateEventPresenter implements OrgCreateEventOutputBoundary {

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
