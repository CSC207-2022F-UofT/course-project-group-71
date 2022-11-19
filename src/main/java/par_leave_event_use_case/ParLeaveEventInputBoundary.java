package par_leave_event_use_case;

import java.sql.SQLException;

public interface ParLeaveEventInputBoundary {
    ParLeaveEventResponseModel leave(ParLeaveEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
