package event_search_use_case;


import java.sql.SQLException;

public interface EventSearchInputBoundary {
    EventSearchResponseModel eventSearch(EventSearchRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
