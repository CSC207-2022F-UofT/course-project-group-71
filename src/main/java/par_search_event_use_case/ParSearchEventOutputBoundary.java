package par_search_event_use_case;

import java.sql.SQLException;

public interface ParSearchEventOutputBoundary {

    ParSearchEventResponseModel prepareSuccessView(ParSearchEventResponseModel results ) throws SQLException, ClassNotFoundException;
    ParSearchEventResponseModel prepareFailView(String error);
}
