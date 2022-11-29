package use_cases;

import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventController;
import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventPresenter;
import controller_presenter_view.common_controller_presenter.org_delete_event.OrgDeleteEventController;
import controller_presenter_view.common_controller_presenter.org_delete_event.OrgDeleteEventPresenter;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastController;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastPresenter;
import database.*;
import use_cases.notify_event_use_case.NotifyEventInputBoundary;
import use_cases.notify_event_use_case.NotifyEventInteractor;
import use_cases.notify_event_use_case.NotifyEventOutputBoundary;
import use_cases.org_delete_event_use_case.OrgDeleteEventInputBoundary;
import use_cases.org_delete_event_use_case.OrgDeleteEventInteractor;
import use_cases.org_delete_event_use_case.OrgDeleteEventOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInteractor;
import use_cases.upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastResponseModel;

import java.sql.SQLException;

public class Util_Method {
    public static UpcomingToPastController utilGetUpcomingToPastControllerHelper(){
        ParDsGateway parDsGateway = new ParFileUser();
        OrgDsGateway orgDsGateway = new OrgFileUser();
        EventDsGateway eventDsGateway = new EventFileUser();
        UpcomingToPastOutputBoundary upcomingToPastOutputBoundary = new UpcomingToPastPresenter();
        UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                eventDsGateway, upcomingToPastOutputBoundary);
        UpcomingToPastController controller = new UpcomingToPastController(interactor);
        return controller;
    }

    public static void utilNotifyEventHelper(UpcomingToPastResponseModel responseModel){
        EventDsGateway eventDsGateway = new EventFileUser();
        ParDsGateway parDsGateway = new ParFileUser();
        NotifyEventOutputBoundary notifyEventOutputBoundary = new NotifyEventPresenter();
        NotifyEventInputBoundary interactor2 = new NotifyEventInteractor(eventDsGateway, parDsGateway,
                notifyEventOutputBoundary);
        NotifyEventController notifyEventController = new NotifyEventController(interactor2);
        for (String event : responseModel.getEventsToPast()){
            try {
                notifyEventController.sendNotification("Past", event);
            } catch (SQLException | ClassNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public static OrgDeleteEventController utilGetDeleteEventControllerHelper(){
        EventDsGateway eventDsGateway = new EventFileUser();

        ParDsGateway parDsGateway = new ParFileUser();

        OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary = new OrgDeleteEventPresenter();

        OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway,
                parDsGateway, orgDeleteEventOutputBoundary);

        OrgDeleteEventController orgDeleteEventController = new OrgDeleteEventController(interactor);
        return orgDeleteEventController;
    }
}
