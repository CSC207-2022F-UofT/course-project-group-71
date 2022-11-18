package org_edit_event_use_case;

public interface OrgEditEventPresenter {
    OrgEditEventResponseModel prepareSuccessView(OrgEditEventResponseModel responseModel);

    OrgEditEventResponseModel prepareFailView(String error);
}
