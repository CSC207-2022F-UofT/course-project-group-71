package notify_event_use_case;

/** Class used to prepare failure or success view.
 */
public interface NotifyEventOutputBoundary {

    /**A method used to show success view to the user
     *
     * @param notificationResponseModel A response model containing information to show success view
     * @return A response model showing success view
     */
    NotifyEventResponseModel prepareSuccessView(NotifyEventResponseModel notificationResponseModel);

    /**A method used to show failure view to the user
     *
     * @param notificationResponseModel A String containing information about how it failed
     * @return A response model showing failure view
     */
    NotifyEventResponseModel prepareFailView(NotifyEventResponseModel notificationResponseModel);
}