package use_cases.par_show_notification_use_case;

public class ParShowNotificationResponseModel {
    final String notifications;

    public ParShowNotificationResponseModel(String notifications) {
        this.notifications = notifications;
    }

    public String getNotifications() {
        return notifications;
    }
}
