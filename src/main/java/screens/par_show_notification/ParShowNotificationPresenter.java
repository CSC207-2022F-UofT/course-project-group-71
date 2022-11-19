package screens.par_show_notification;

import par_show_notification_use_case.ParShowNotificationOutputBoundary;
import par_show_notification_use_case.ParShowNotificationResponseModel;
import screens.ShowMessageView;

// Interface adapters layer

public class ParShowNotificationPresenter implements ParShowNotificationOutputBoundary {

    /**Call ShowSuccessView to prepare a notification success/failure view.
     *
     * @param message The messge need to be sent
     * @return A responsemodel to be sent back to the controller.
     */
    @Override
    public ParShowNotificationResponseModel prepareView(String message) {
        throw new ShowMessageView(message);
    }
}