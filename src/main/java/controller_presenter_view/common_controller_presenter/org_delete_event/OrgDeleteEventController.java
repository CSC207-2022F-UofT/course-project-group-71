package controller_presenter_view.common_controller_presenter.org_delete_event;

import org_delete_event_use_case.*;

import java.sql.SQLException;

/**The controller will be called by:
 * 1. OrgUnpublishedEventActionListener When the organization clicks the "Delete" button on OrgUnpublishedEventPage
 * 2. OrgUpcomingEventActionListener    When the organization clicks the "Delete" button on OrgUpcomingEventPage
 */
public class OrgDeleteEventController {
    OrgDeleteEventInputBoundary userInput;

    public OrgDeleteEventController(OrgDeleteEventInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public OrgDeleteEventResponseModel delete(String eventName) throws SQLException, ClassNotFoundException {
        OrgDeleteEventRequestModel requestModel = new OrgDeleteEventRequestModel(eventName);
        return userInput.delete(requestModel);
    }

}
