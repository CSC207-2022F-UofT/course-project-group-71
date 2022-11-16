package event_search_use_case;

import org_search_use_case.OrgSearchResponseModel;

public interface EventSearchOutputBoundary {

    EventSearchResponseModel prepareSuccessView(EventSearchResponseModel results );
    EventSearchResponseModel prepareFailView(String error);
}
