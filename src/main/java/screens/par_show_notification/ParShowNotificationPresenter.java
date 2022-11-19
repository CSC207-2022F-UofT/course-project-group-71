package screens.par_show_notification;

import par_show_notification_use_case.ParShowNotificationOutputBoundary;
import par_show_notification_use_case.ParShowNotificationResponseModel;
import screens.ShowMessageView;

// Interface adapters layer

public class ParShowNotificationPresenter implements ParShowNotificationOutputBoundary {
    @Override
    public ParShowNotificationResponseModel prepareView(String message) {
        throw new ShowMessageView(message);
    }
}