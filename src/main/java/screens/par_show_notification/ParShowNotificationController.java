package screens.par_show_notification;

import par_show_notification_use_case.*;

import java.sql.SQLException;

public class ParShowNotificationController {
    final ParShowNotificationInputBoundary userInput;

    public ParShowNotificationController(ParShowNotificationInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public ParShowNotificationResponseModel showNotification(String username) throws SQLException, ClassNotFoundException {
        ParShowNotificationRequestModel requestModel = new ParShowNotificationRequestModel(username);

        return userInput.showNotification(requestModel);
    }
}
