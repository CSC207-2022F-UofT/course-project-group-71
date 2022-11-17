package event_search_use_case;


public interface EventSearchInputBoundary {
    EventSearchResponseModel eventSearch(EventSearchRequestModel requestModel);
}
