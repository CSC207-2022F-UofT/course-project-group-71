package par_leave_event_use_case;

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
