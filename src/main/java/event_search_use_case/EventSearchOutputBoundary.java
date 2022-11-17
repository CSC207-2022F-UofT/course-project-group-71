package event_search_use_case;

public interface EventSearchOutputBoundary {

    EventSearchResponseModel prepareSuccessView(EventSearchResponseModel results );
    EventSearchResponseModel prepareFailView(String error);
}
