package controller_presenter_view.common_controller_presenter.par_leave_event;

import use_cases.par_leave_event_use_case.ParLeaveEventInputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventRequestModel;
import use_cases.par_leave_event_use_case.ParLeaveEventResponseModel;

/**The controller will be called by:
 * 1. ParSearchEventResultsPageActionListener   When the participant clicks the "Leave" button on ParSearchEventResultsPage
 * 2. ParUpcomingEventActionListener            When the organization clicks the "Leave" button on ParUpcomingEventPage
 */
public class ParLeaveEventController {

    final ParLeaveEventInputBoundary interactor;

    public ParLeaveEventController(ParLeaveEventInputBoundary interactor) {
        this.interactor = interactor;
    }

    public ParLeaveEventResponseModel leave(String par_username, String event_title) throws ClassNotFoundException {
        ParLeaveEventRequestModel requestModel = new ParLeaveEventRequestModel(par_username,event_title);
        return interactor.leave(requestModel);
    }
}
