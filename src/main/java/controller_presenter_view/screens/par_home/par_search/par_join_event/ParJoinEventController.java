package controller_presenter_view.screens.par_home.par_search.par_join_event;

import use_cases.par_join_event_use_case.ParJoinEventInputBoundary;
import use_cases.par_join_event_use_case.ParJoinEventRequestModel;
import use_cases.par_join_event_use_case.ParJoinEventResponseModel;


public class ParJoinEventController {

    final ParJoinEventInputBoundary interactor;

    public ParJoinEventController(ParJoinEventInputBoundary interactor) {
        this.interactor = interactor;
    }

    public ParJoinEventResponseModel join(String par_username, String event_name) {
        ParJoinEventRequestModel requestModel = new ParJoinEventRequestModel(par_username, event_name);
        try {
            return interactor.join(requestModel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}