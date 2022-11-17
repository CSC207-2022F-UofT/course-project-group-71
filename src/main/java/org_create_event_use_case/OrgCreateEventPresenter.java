package org_create_event_use_case;

public interface OrgCreateEventPresenter {
    OrgCreateEventResponseModel prepareSuccessView(OrgCreateEventResponseModel responseModel);

    OrgCreateEventResponseModel prepareFailView(String error);
}
