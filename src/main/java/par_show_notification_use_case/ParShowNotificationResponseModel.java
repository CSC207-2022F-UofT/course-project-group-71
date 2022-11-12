package par_show_notification_use_case;

import java.util.ArrayList;

public class ParShowNotificationResponseModel {
    String notifications;

    public ParShowNotificationResponseModel(String notifications) {
        this.notifications = notifications;
    }

    public String getNotifications() {
        return notifications;
    }
}
