package screens.par_show_notification;

import par_show_notification_use_case.*;

import java.sql.SQLException;

public class ParShowNotificationController {
    final ParShowNotificationInputBoundary userInput;

    /**The contructor of the controller of notification.
     *
     * @param accountGateway The interactor for notification showing
     */
    public ParShowNotificationController(ParShowNotificationInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    /**The method used to show notification by calling interact, it returns a response model.
     *
     * @param username The username of the participant
     * @return The respondent sent back from the interactor.
     * @throws SQLException Exception when SQL error occurs.
     * @throws ClassNotFoundException Exception when Class error occurs.
     */
    public ParShowNotificationResponseModel showNotification(String username) throws SQLException, ClassNotFoundException {
        ParShowNotificationRequestModel requestModel = new ParShowNotificationRequestModel(username);

        return userInput.showNotification(requestModel);
    }
}
