package par_show_notification_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;
import user_login_use_case.OrgHomePresenter;
import user_login_use_case.ParHomePresenter;

import java.util.ArrayList;

public class ParShowNotificationInteractor implements ParShowNotificationInputBoundary {

    private ParShowNotificationPresenter parShowNotificationPresenter;
    private ParDsGateway parDsGateway;

    public ParShowNotificationInteractor(ParShowNotificationPresenter parShowNotificationPresenter, ParDsGateway parDsGateway) {
        this.parShowNotificationPresenter = parShowNotificationPresenter;
        this.parDsGateway = parDsGateway;
    }
    
    public ParShowNotificationResponseModel showNotification(ParShowNotificationRequestModel requestModel) {
        ArrayList<String> notifications = parDsGateway.getNotifications(requestModel.getUsername());
        if (!notifications.isEmpty()){
            String notification = "";
            for (String n : notifications) {
                notification += n+"\n";
            }
            return parShowNotificationPresenter.prepareView(notification);
        }
        else {
            return parShowNotificationPresenter.prepareView("You have no notification!");
        }
    }
}
