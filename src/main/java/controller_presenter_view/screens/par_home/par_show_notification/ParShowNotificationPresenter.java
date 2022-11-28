package controller_presenter_view.screens.par_home.par_show_notification;

import use_cases.par_show_notification_use_case.ParShowNotificationOutputBoundary;
import use_cases.par_show_notification_use_case.ParShowNotificationResponseModel;
import controller_presenter_view.common_view.ShowMessageView;

// Interface adapters layer

public class ParShowNotificationPresenter implements ParShowNotificationOutputBoundary {

    /**Call ShowSuccessView to prepare a notification success/failure view.
     *
     * @return A responsemodel to be sent back to the controller.
     */
    public ParShowNotificationResponseModel prepareSuccessView(ParShowNotificationResponseModel responseModel) {
        return responseModel;
    }
    @Override
    public ParShowNotificationResponseModel prepareFailView(String message) {
        throw new ShowMessageView(message);
    }
}