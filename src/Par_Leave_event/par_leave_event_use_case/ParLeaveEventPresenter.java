package par_leave_event_use_case;

public class ParLeaveEventPresenter implements ParLeaveEventOutputBoundary {

    public ParLeaveEventResponseModel prepareSuccessView(ParLeaveEventResponseModel responseModel) {
        responseModel.setMessage("You have left the event " + responseModel.getEvent_title() + ".");
        return responseModel;
    }
}
