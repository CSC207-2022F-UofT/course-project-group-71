package org_publish_event_use_case;

/** Class used to prepare success view.
 */
public interface OrgPublishEventOutputBoundary {

    /**A method used to show success view to the user
     *
     * @param orgPublishEventResponseModel A response model containing information to show success view
     * @return A response model showing success view
     */
    OrgPublishEventResponseModel prepareSuccessView(OrgPublishEventResponseModel orgPublishEventResponseModel);

    /**A method used to show failure view to the user
     *
     * @param error A String containing information about how it failed
     * @return A response model showing failure view
     */
    OrgPublishEventResponseModel prepareFailView(String error);

}
