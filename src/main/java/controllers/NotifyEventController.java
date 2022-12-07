package controllers;

import use_cases.notify_event_use_case.NotifyEventInputBoundary;
import use_cases.notify_event_use_case.NotifyEventRequestModel;
import use_cases.notify_event_use_case.NotifyEventResponseModel;

/**The controller will be called by:
 * 1. OrgHomeActionListener             When the organization clicks to the OrgUpcomingEventPage or OrgPastEventPage from OrgHomePage
 * 2. OrgUpcomingEventActionListener    When the organization clicks the "Notify" button on org upcoming event page
 * 3. LoginPage                         When a participant user clicks the "Login" button
 */
public class NotifyEventController {
    final NotifyEventInputBoundary notifyEventInputBoundary;

    public NotifyEventController(NotifyEventInputBoundary accountGateway) {
        this.notifyEventInputBoundary = accountGateway;
    }

    public NotifyEventResponseModel sendNotification(String notificationType, String eventName) throws ClassNotFoundException {
        NotifyEventRequestModel requestModel = new NotifyEventRequestModel(notificationType, eventName);
        return notifyEventInputBoundary.sendNotification(requestModel);
    }
}
