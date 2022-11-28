package par_leave_event_use_case;

import java.sql.SQLException;

/**The controller will be called by:
 * 1. ParSearchEventResultsPageActionListener   When the participant clicks the "Leave" button on ParSearchEventResultsPage
 * 2. ParUpcomingEventActionListener            When the organization clicks the "Leave" button on ParUpcomingEventPage
 */
public class ParLeaveEventController {

    ParLeaveEventInputBoundary interactor;

    public ParLeaveEventController(ParLeaveEventInputBoundary interactor) {
        this.interactor = interactor;
    }

    public ParLeaveEventResponseModel leave(String par_username, String event_title) throws SQLException, ClassNotFoundException {
        ParLeaveEventRequestModel requestModel = new ParLeaveEventRequestModel(par_username,event_title);
        return interactor.leave(requestModel);
    }
}
