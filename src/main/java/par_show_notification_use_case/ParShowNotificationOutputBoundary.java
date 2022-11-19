package par_show_notification_use_case;

public interface ParShowNotificationOutputBoundary {
    ParShowNotificationResponseModel prepareView(String error);
}