package par_leave_event_use_case;

import LeaveTheEventScreen.FaliureViewModel;
import LeaveTheEventScreen.SuccessfulViewModule;

public class ParLeaveEventPresenter implements ParLeaveEventOutputBoundary {

    @Override
    public void faliure_view_preparation(ParLeaveEventResponseModel failureresponse) {
        String par_username = failureresponse.getPar_username();
        String event_title = failureresponse.getEvent_title();
        String message = failureresponse.getMessage();
        FaliureViewModel f = new FaliureViewModel(message);
        f.GeneratePage();
    }

    public void success_view_preparation(ParLeaveEventResponseModel successresponse) {
        String par_username = successresponse.getPar_username();
        String event_title = successresponse.getEvent_title();
        String message = successresponse.getMessage();
        SuccessfulViewModule f = new SuccessfulViewModule(message);
        f.GeneratePage();
    }
}
