package participant_leave_the_event;

import LeaveTheEventScreen.FaliureViewModel;
import LeaveTheEventScreen.SuccessfulViewModule;

public class EventLeavePresenter implements EventLeaveOutputBoundary{

    @Override
    public void faliure_view_preparation(EventLeaveResponseModel failureresponse) {
        String par_username = failureresponse.getPar_username();
        String event_title = failureresponse.getEvent_title();
        String message = failureresponse.getMessage();
        FaliureViewModel f = new FaliureViewModel(message);
        f.GeneratePage();
    }

    public void success_view_preparation(EventLeaveResponseModel successresponse) {
        String par_username = successresponse.getPar_username();
        String event_title = successresponse.getEvent_title();
        String message = successresponse.getMessage();
        SuccessfulViewModule f = new SuccessfulViewModule(message);
        f.GeneratePage();
    }
}
