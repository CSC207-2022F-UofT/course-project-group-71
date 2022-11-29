package use_cases.par_join_event_use_case;

import java.sql.SQLException;

public interface ParJoinEventInputBoundary {
    /**Use the information contained in the request model to let a participant join an event and response model.
     *
     * @param requestModel The request model sent to the input boundary
     */
    ParJoinEventResponseModel join(ParJoinEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
