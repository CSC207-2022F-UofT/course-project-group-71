package controller_presenter_view.screens.par_home.par_search.par_join_event;

import par_join_event_use_case.ParJoinEventOutputBoundary;
import par_join_event_use_case.ParJoinEventResponseModel;

public class ParJoinEventPresenter implements ParJoinEventOutputBoundary {

    @Override
    public ParJoinEventResponseModel prepareSuccessView(ParJoinEventResponseModel response) {
        response.setMessage("Registered successfully for " + response.getEventName() + "!");
        return response;
    }
}
