package par_leave_event_use_case;

public interface ParLeaveEventOutputBoundary {
    void faliure_view_preparation(ParLeaveEventResponseModel failureresponse);

    void success_view_preparation(ParLeaveEventResponseModel successresponse);
}
