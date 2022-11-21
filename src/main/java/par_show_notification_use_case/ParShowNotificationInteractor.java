package par_show_notification_use_case;

import database.ParDsGateway;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParShowNotificationInteractor implements ParShowNotificationInputBoundary {

    private ParShowNotificationOutputBoundary parShowNotificationPresenter;
    private ParDsGateway parDsGateway;
    /**This is the construct method of ParShowNotificationInteractor.
     * It takes ParGateways and Presenter as input to store as instances.
     *
     * @param parShowNotificationPresenter The presenter used to show the notifications.
     * @param parDsGateway The participants gateway of the participants.
     */

    public ParShowNotificationInteractor(ParShowNotificationOutputBoundary parShowNotificationPresenter, ParDsGateway parDsGateway) {
        this.parShowNotificationPresenter = parShowNotificationPresenter;
        this.parDsGateway = parDsGateway;
    }
    /**Use the information contained in the requestModel to check with database and respond a responseModel.
     * It took the request model and calls the getNotifications method in parDsGateway with the function
     * getUsername in the request model and save that into an Arraylist of Strings called notifications.
     * If the arraylist is not empty, it will loop notifications so each item will saved as a string called notification
     * with a new line character.
     * Then it deletes all notifications for this participant.
     * Then it returns the notification request model back to the presenter.
     * If the arraylist is empty, it returns "You have no notification!" request model back to the presenter.
     *
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the notification if there is or "You have no notification!" if there isn't.
     */
    public ParShowNotificationResponseModel showNotification(ParShowNotificationRequestModel requestModel) throws SQLException, ClassNotFoundException {
        ArrayList<String> notifications = parDsGateway.getNotifications(requestModel.getUsername());
        if (!notifications.isEmpty()){
            StringBuilder notification = new StringBuilder();
            for (String n : notifications) {
                notification.append(n).append("\n");
            }
            parDsGateway.clearNotifications(requestModel.getUsername());
            ParShowNotificationResponseModel responseModel = new ParShowNotificationResponseModel(notification.toString());
            return parShowNotificationPresenter.prepareSuccessView(responseModel);
        }
        else {
            return parShowNotificationPresenter.prepareFailView("You have no notification!");
        }
    }
}
