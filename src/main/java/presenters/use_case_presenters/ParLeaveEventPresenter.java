package presenters.use_case_presenters;

import use_cases.par_leave_event_use_case.ParLeaveEventOutputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventResponseModel;

public class ParLeaveEventPresenter implements ParLeaveEventOutputBoundary {

    public ParLeaveEventResponseModel prepareSuccessView(ParLeaveEventResponseModel responseModel) {
        responseModel.setMessage("You have left the event " + responseModel.getEvent_title() + ".");
        return responseModel;
    }
}
