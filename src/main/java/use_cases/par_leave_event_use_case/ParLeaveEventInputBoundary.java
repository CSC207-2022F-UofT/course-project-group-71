package use_cases.par_leave_event_use_case;

import java.sql.SQLException;

public interface ParLeaveEventInputBoundary {
    /**Use the information contained in the request model to let a participant leave an event and response model.
     *
     * @param requestModel The request model sent to the input boundary
     */
    ParLeaveEventResponseModel leave(ParLeaveEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
