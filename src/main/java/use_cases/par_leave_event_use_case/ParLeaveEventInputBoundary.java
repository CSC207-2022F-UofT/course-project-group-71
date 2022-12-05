package use_cases.par_leave_event_use_case;

public interface ParLeaveEventInputBoundary {
    /**Use the information contained in the request model to let a participant leave an event and response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    ParLeaveEventResponseModel leave(ParLeaveEventRequestModel requestModel) throws ClassNotFoundException;
}
