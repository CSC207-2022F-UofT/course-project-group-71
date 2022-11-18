package screens.par_upcoming_event;

import par_leave_event_use_case.ParLeaveEventInputBoundary;
import par_leave_event_use_case.ParLeaveEventRequestModel;

public class ParLeaveEventController {

    final ParLeaveEventInputBoundary interactor;

    public ParLeaveEventController(ParLeaveEventInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void leave(String par_username, String event_title) {
        ParLeaveEventRequestModel requestModel = new ParLeaveEventRequestModel(par_username,event_title);

        interactor.leave(requestModel);
    }
}
