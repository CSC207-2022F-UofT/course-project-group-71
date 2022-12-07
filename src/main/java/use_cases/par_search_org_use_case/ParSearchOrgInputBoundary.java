package use_cases.par_search_org_use_case;

/** Interface implements by interactor.
 * The interactor who implement the interface must have orgSearch() method.
 */
public interface ParSearchOrgInputBoundary {
    /**Use the information contained in the request model to search an organizer and respond a response model.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A response model representing whether the search for org is successful
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    ParSearchOrgResponseModel orgSearch(ParSearchOrgRequestModel requestModel) throws ClassNotFoundException;
}
