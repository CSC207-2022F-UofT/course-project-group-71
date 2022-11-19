package par_search_event_use_case;


import java.sql.SQLException;

public interface ParSearchEventInputBoundary {
    ParSearchEventResponseModel eventSearch(ParSearchEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
