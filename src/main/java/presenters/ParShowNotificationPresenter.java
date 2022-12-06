package presenters;

import use_cases.par_show_notification_use_case.ParShowNotificationOutputBoundary;
import use_cases.par_show_notification_use_case.ParShowNotificationResponseModel;
import screens.common_view.ShowMessageView;

// Interface adapters layer

public class ParShowNotificationPresenter implements ParShowNotificationOutputBoundary {

    /**Call ShowSuccessView to prepare a notification success/failure view.
     *
     * @return A response model to be sent back to the controller.
     */
    public ParShowNotificationResponseModel prepareSuccessView(ParShowNotificationResponseModel responseModel) {
        return responseModel;
    }
    @Override
    public ParShowNotificationResponseModel prepareFailView(String message) {
        throw new ShowMessageView(message);
    }
}