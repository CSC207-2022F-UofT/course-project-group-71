package org_edit_event_use_case;

public interface OrgEditEventOutputBoundary {
    OrgEditEventResponseModel prepareSuccessView(OrgEditEventResponseModel responseModel);

    OrgEditEventResponseModel prepareFailView(String error);
}
