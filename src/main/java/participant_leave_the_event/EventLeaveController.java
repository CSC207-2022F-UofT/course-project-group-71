package participant_leave_the_event;

public class EventLeaveController {

    final EventLeaveInputBoundary interactor;

    public EventLeaveController(EventLeaveInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void leave(String par_username, String event_title) {
        EventLeaveRequestModel requestModel = new EventLeaveRequestModel(par_username,event_title);

        interactor.leave(requestModel);
    }
}
