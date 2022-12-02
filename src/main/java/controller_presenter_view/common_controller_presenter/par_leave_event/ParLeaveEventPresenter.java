package controller_presenter_view.common_controller_presenter.par_leave_event;

import use_cases.par_leave_event_use_case.ParLeaveEventOutputBoundary;
import use_cases.par_leave_event_use_case.ParLeaveEventResponseModel;

public class ParLeaveEventPresenter implements ParLeaveEventOutputBoundary {

    public ParLeaveEventResponseModel prepareSuccessView(ParLeaveEventResponseModel responseModel) {
        responseModel.setMessage("You have left the event " + responseModel.getEvent_title() + ".");
        return responseModel;
    }
}
