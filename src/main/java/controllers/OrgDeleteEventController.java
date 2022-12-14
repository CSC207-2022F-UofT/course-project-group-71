package controllers;

import use_cases.org_delete_event_use_case.OrgDeleteEventInputBoundary;
import use_cases.org_delete_event_use_case.OrgDeleteEventRequestModel;
import use_cases.org_delete_event_use_case.OrgDeleteEventResponseModel;

/**The controller will be called by:
 * 1. OrgUnpublishedEventActionListener When the organization clicks the "Delete" button on OrgUnpublishedEventPage
 * 2. OrgUpcomingEventActionListener    When the organization clicks the "Delete" button on OrgUpcomingEventPage
 */
public class OrgDeleteEventController {
    final OrgDeleteEventInputBoundary userInput;

    public OrgDeleteEventController(OrgDeleteEventInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public OrgDeleteEventResponseModel delete(String eventName) throws ClassNotFoundException {
        OrgDeleteEventRequestModel requestModel = new OrgDeleteEventRequestModel(eventName);
        return userInput.delete(requestModel);
    }

}
