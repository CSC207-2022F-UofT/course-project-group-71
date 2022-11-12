package screens.par_show_notification;

import par_show_notification_use_case.ParShowNotificationPresenter;
import par_show_notification_use_case.ParShowNotificationResponseModel;
import screens.ShowMessageView;
import user_login_use_case.UserLoginPresenter;
import user_login_use_case.UserLoginResponseModel;

import java.util.ArrayList;

// Interface adapters layer

public class ParShowNotificationResponseFormatter implements ParShowNotificationPresenter {
    @Override
    public ParShowNotificationResponseModel prepareView(String message) {
        throw new ShowMessageView(message);
    }
}