package screens.upcoming_to_past;

import upcoming_to_past_use_case.UpcomingToPastPresenter;
import upcoming_to_past_use_case.UpcomingToPastResponseModel;

public class UpcomingToPastResponseFormatter implements UpcomingToPastPresenter {
    @Override
    public UpcomingToPastResponseModel prepareSuccessView(UpcomingToPastResponseModel responseModel) {
        String message = "The following event(s) has(ve) been moved from Upcoming Event to Past Event due to the time:";

        for (String event : responseModel.getEventsToPast()){
            message += "\n" + event;
        }
        responseModel.setMessage(message);
        return responseModel;
    }
}
