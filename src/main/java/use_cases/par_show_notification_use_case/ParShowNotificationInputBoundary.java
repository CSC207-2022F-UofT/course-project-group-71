package use_cases.par_show_notification_use_case;

import java.sql.SQLException;

public interface ParShowNotificationInputBoundary {
    ParShowNotificationResponseModel showNotification(ParShowNotificationRequestModel requestModel) throws SQLException, ClassNotFoundException;
}