package controller_presenter_view.screens.par_home.par_show_notification;

import use_cases.par_show_notification_use_case.ParShowNotificationInputBoundary;
import use_cases.par_show_notification_use_case.ParShowNotificationRequestModel;
import use_cases.par_show_notification_use_case.ParShowNotificationResponseModel;

public class ParShowNotificationController {
    final ParShowNotificationInputBoundary userInput;

    /**The contractor of the controller of notification.
     *
     * @param accountGateway The interactor for notification showing
     */
    public ParShowNotificationController(ParShowNotificationInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    /**The method used to show notification by calling interact, it returns a response model.
     *
     * @param username The username of the participant.
     * @return The respondent sent back from the interactor.
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ParShowNotificationResponseModel showNotification(String username) throws ClassNotFoundException {
        ParShowNotificationRequestModel requestModel = new ParShowNotificationRequestModel(username);

        return userInput.showNotification(requestModel);
    }
}
