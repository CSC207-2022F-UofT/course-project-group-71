package screens;

import controllers.NotifyEventController;
import controllers.OrgDeleteEventController;
import controllers.UpcomingToPastController;
import database.*;
import presenters.use_case_presenters.NotifyEventPresenter;
import presenters.use_case_presenters.OrgDeleteEventPresenter;
import presenters.use_case_presenters.UpcomingToPastPresenter;
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

public class CommonMethod {

    /**The method will convert relative upcoming events of the user to past events if their time are in the past, then
     * notify the participants of the events.
     *
     * @param userType the type of the user (Participant or Organization)
     * @param username the username of the user
     */
    public static void convertAndNotify(String userType, String username){
        //convert upcoming events to past events if their time are in the past
        ParDsGateway parDsGateway = new ParFileUser();
        OrgDsGateway orgDsGateway = new OrgFileUser();
        EventDsGateway eventDsGateway = new EventFileUser();
        UpcomingToPastOutputBoundary upcomingToPastOutputBoundary = new UpcomingToPastPresenter();
        UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                eventDsGateway, upcomingToPastOutputBoundary);
        UpcomingToPastController controller = new UpcomingToPastController(interactor);
        UpcomingToPastResponseModel responseModel;
        try {
            responseModel = controller.convertToPast(userType, username);
        } catch (ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }

        //notify the relevant participant of the events
        if (!responseModel.getEventsToPast().isEmpty()) {
            NotifyEventOutputBoundary notifyEventOutputBoundary = new NotifyEventPresenter();
            NotifyEventInputBoundary interactor2 = new NotifyEventInteractor(eventDsGateway, parDsGateway,
                    notifyEventOutputBoundary);
            NotifyEventController notifyEventController = new NotifyEventController(interactor2);
            for (String event : responseModel.getEventsToPast()){
                try {
                    notifyEventController.sendNotification("Past", event);
                } catch (ClassNotFoundException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
    }

    /**The method will initialize an OrgDeleteEventController.
     *
     * @return OrgDeleteEventController
     */
    public static OrgDeleteEventController utilGetDeleteEventControllerHelper(){
        EventDsGateway eventDsGateway = new EventFileUser();

        ParDsGateway parDsGateway = new ParFileUser();

        OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary = new OrgDeleteEventPresenter();

        OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway,
                parDsGateway, orgDeleteEventOutputBoundary);

        return new OrgDeleteEventController(interactor);
    }

    /**The method will return the keyword that is contained an actionCommand.
     * Ex. actionCommand: eventDelete, keyword: event
     *
     * @return the keyword
     */
    public static String keywordTaker(String actionCommand, int i){
        return actionCommand.substring(0, actionCommand.length() - i);
    }
}
