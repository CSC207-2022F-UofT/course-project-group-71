package screens.par_show_notification;

import par_show_notification_use_case.*;

public class ParShowNotificationController {
    final ParShowNotificationInputBoundary userInput;

    public ParShowNotificationController(ParShowNotificationInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public ParShowNotificationResponseModel showNotification(String username) {
        ParShowNotificationRequestModel requestModel = new ParShowNotificationRequestModel(username);

        return userInput.showNotification(requestModel);
    }
}
