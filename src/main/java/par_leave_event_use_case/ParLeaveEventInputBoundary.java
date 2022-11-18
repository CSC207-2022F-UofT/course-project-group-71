package par_leave_event_use_case;

public interface ParLeaveEventInputBoundary {
    ParLeaveEventResponseModel leave(ParLeaveEventRequestModel requestModel);
}
