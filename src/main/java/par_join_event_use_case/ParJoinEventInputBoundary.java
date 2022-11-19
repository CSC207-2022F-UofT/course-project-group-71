package par_join_event_use_case;

import java.sql.SQLException;

public interface ParJoinEventInputBoundary {
    ParJoinEventResponseModel join(ParJoinEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
