package use_cases.par_join_event_use_case;

public interface ParJoinEventOutputBoundary {
    ParJoinEventResponseModel prepareSuccessView(ParJoinEventResponseModel parJoinEventResponseModel);
    //since the register of the event will not fail, we only have to prepare the success view.
}
