package screens.par_upcoming_event;

import par_leave_event_use_case.ParLeaveEventOutputBoundary;
import par_leave_event_use_case.ParLeaveEventResponseModel;

public class ParLeaveEventPresenter implements ParLeaveEventOutputBoundary {

    public ParLeaveEventResponseModel prepareSuccessView(ParLeaveEventResponseModel response) {
        response.setMessage(response.getMessage());
        return response;
    }
}
