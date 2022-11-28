package use_cases.org_create_event_use_case;

/** Class used to prepare failure or success view for creating an evnet.
 */
public interface OrgCreateEventOutputBoundary {
    /**A method used to show a success view to the user
     *
     * @param responseModel A response model containing information to show in success view
     * @return A response model showing the success view
     */
    OrgCreateEventResponseModel prepareSuccessView(OrgCreateEventResponseModel responseModel);

    /**A method used to show a failure view to the user
     *
     * @param error A string containing information about how event creation failed
     * @return A response model showing the failure view
     */
    OrgCreateEventResponseModel prepareFailView(String error);
}
