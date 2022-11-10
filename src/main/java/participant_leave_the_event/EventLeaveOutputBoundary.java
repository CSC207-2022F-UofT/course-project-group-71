package participant_leave_the_event;

public interface EventLeaveOutputBoundary {
    void faliure_view_preparation(EventLeaveResponseModel failureresponse);

    void success_view_preparation(EventLeaveResponseModel successresponse);
}
