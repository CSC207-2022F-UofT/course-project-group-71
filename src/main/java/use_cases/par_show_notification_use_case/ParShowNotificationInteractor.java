package use_cases.par_show_notification_use_case;

import database.ParDsGateway;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParShowNotificationInteractor implements ParShowNotificationInputBoundary {

    ParShowNotificationOutputBoundary outputBoundary;
    ParDsGateway parDsGateway;

    /**Constructor
     *
     * @param outputBoundary The presenter used to show the notifications.
     * @param parDsGateway The participants gateway of the participants.
     */
    public ParShowNotificationInteractor(ParShowNotificationOutputBoundary outputBoundary, ParDsGateway parDsGateway) {
        this.outputBoundary = outputBoundary;
        this.parDsGateway = parDsGateway;
    }

    /**If the participant has notification to show, return responseModel with the notification. All notifications will
     * be removed from database after showing.
     * If the participant has no notification to show, return failure message.
     * Note: All notifications will show up at the same time and can only be seen once.
     * 
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the notification if there is or "You have no notification!" if there isn't.
     */
    public ParShowNotificationResponseModel showNotification(ParShowNotificationRequestModel requestModel) throws SQLException, ClassNotFoundException {
        ArrayList<String> notifications = parDsGateway.getNotifications(requestModel.getUsername());
        if (!notifications.isEmpty()){
            StringBuilder notification = new StringBuilder();
            
            //format the notifications
            for (String n : notifications) {
                notification.append(n).append("\n");
            }
            
            parDsGateway.clearNotifications(requestModel.getUsername());
            ParShowNotificationResponseModel responseModel = new ParShowNotificationResponseModel(notification.toString());
            return outputBoundary.prepareSuccessView(responseModel);
        }
        else {
            return outputBoundary.prepareFailView("You have no notification!");
        }
    }
}
