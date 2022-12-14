package use_cases.par_join_event_use_case;

public interface ParJoinEventInputBoundary {
    /**Use the information contained in the request model to let a participant join an event and response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    ParJoinEventResponseModel join(ParJoinEventRequestModel requestModel) throws ClassNotFoundException;
}
