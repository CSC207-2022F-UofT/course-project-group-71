package org_delete_event_use_case;

/** Class used to prepare success view.
 */
public interface OrgDeleteEventOutputBoundary {
    /**A method used to show success view to the user
     *
     * @param orgDeleteEventResponseModel A response model containing information to show success view
     * @return A response model showing success view
     */
    OrgDeleteEventResponseModel prepareSuccessView(OrgDeleteEventResponseModel orgDeleteEventResponseModel);
}
