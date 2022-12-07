package use_cases.par_search_org_use_case;

/** Class used to prepare failure or success view.
 */
public interface ParSearchOrgOutputBoundary {

    /**A method used to show success view to the user
     *
     * @param results A response model containing information to show success view
     * @return A response model showing failure view
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    ParSearchOrgResponseModel prepareSuccessView(ParSearchOrgResponseModel results ) throws ClassNotFoundException;

    /**A method used to show failure view to the user
     *
     * @param error A String containing information about how it failed
     * @return A response model showing success view
     */
    ParSearchOrgResponseModel prepareFailView(String error);

}
