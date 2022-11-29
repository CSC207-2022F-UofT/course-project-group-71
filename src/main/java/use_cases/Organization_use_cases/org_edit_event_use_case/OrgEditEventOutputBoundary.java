package use_cases.org_edit_event_use_case;

/** Class used to prepare failure or success view.
 */
public interface OrgEditEventOutputBoundary {

    /**A method used to show success view to the user
     *
     * @param responseModel A response model containing information to show success view
     * @return A response model showing success view
     */
    OrgEditEventResponseModel prepareSuccessView(OrgEditEventResponseModel responseModel);

    /**A method used to show failure view to the user
     *
     * @param error A String containing information about how it failed
     * @return A response model showing failure view
     */
    OrgEditEventResponseModel prepareFailView(String error);
}
