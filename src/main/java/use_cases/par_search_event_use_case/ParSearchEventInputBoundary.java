package use_cases.par_search_event_use_case;

/** Interface implements by interactor.
 * The interactor who implement the interface must have eventSearch() method.
 */
public interface ParSearchEventInputBoundary {
    /**Use the information contained in the request model to search an event and respond a response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A response model representing whether the search for event is successful
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    ParSearchEventResponseModel eventSearch(ParSearchEventRequestModel requestModel) throws ClassNotFoundException;
}
