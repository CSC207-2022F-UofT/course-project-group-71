package org_edit_event_use_case;

/** Class used to prepare failure or success view.
 */
public interface OrgEditEventPresenter {
    /**A method used to show success view to the user
     *
     * @param responseModel A response model containing information to show success view
     * @return A response model showing failure view
     */
    OrgEditEventResponseModel prepareSuccessView(OrgEditEventResponseModel responseModel);

    /**A method used to show failure view to the user
     *
     * @param error A String containing information about how to fail
     * @return A response model showing failure view
     */
    OrgEditEventResponseModel prepareFailView(String error);
}
