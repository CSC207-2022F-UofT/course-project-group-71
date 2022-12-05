package controller_presenter_view.common_controller_presenter.org_delete_event;

import use_cases.org_delete_event_use_case.OrgDeleteEventOutputBoundary;
import use_cases.org_delete_event_use_case.OrgDeleteEventResponseModel;

public class OrgDeleteEventPresenter implements OrgDeleteEventOutputBoundary {
    @Override
    public OrgDeleteEventResponseModel prepareSuccessView(OrgDeleteEventResponseModel response) {
        response.setMessage("Event " + response.getEventName() + " is deleted.");
        return response;
    }
}
