package presenters.use_case_presenters;

import use_cases.upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastResponseModel;

public class UpcomingToPastPresenter implements UpcomingToPastOutputBoundary {
    @Override
    public UpcomingToPastResponseModel prepareSuccessView(UpcomingToPastResponseModel responseModel) {
        StringBuilder message = new StringBuilder("The following event(s) has(ve) been moved from Upcoming Event to Past Event due to the time:");

        for (String event : responseModel.getEventsToPast()){
            message.append("\n").append(event);
        }
        responseModel.setMessage(message.toString());
        return responseModel;
    }
}
