package event_search_use_case;

import java.sql.SQLException;

public interface EventSearchOutputBoundary {

    EventSearchResponseModel prepareSuccessView(EventSearchResponseModel results ) throws SQLException, ClassNotFoundException;
    EventSearchResponseModel prepareFailView(String error);
}
