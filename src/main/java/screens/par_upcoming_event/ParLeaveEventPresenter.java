package screens.par_upcoming_event;

import par_leave_event_use_case.ParLeaveEventOutputBoundary;
import par_leave_event_use_case.ParLeaveEventResponseModel;

public class ParLeaveEventPresenter implements ParLeaveEventOutputBoundary {

    /**Prepare the success view when the operation are successful.
     *
     * @param response The response send from the interactor
     * @return
     */
    public ParLeaveEventResponseModel prepareSuccessView(ParLeaveEventResponseModel response) {
        response.setMessage("You have left the event " + response.getEvent_title() + ".");
        return response;
    }
}
