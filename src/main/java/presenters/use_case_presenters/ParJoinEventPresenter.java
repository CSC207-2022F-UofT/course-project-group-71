package presenters.use_case_presenters;

import use_cases.par_join_event_use_case.ParJoinEventOutputBoundary;
import use_cases.par_join_event_use_case.ParJoinEventResponseModel;

public class ParJoinEventPresenter implements ParJoinEventOutputBoundary {

    @Override
    public ParJoinEventResponseModel prepareSuccessView(ParJoinEventResponseModel response) {
        response.setMessage("Registered successfully for " + response.getEventName() + "!");
        return response;
    }
}
