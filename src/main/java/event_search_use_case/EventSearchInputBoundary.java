package event_search_use_case;

import event_search_use_case.EventSearchRequestModel;
import event_search_use_case.EventSearchResponseModel;

public interface EventSearchInputBoundary {
    EventSearchResponseModel eventSearch(EventSearchResponseModel requestModel);
}
