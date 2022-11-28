package Par_Join_Event_Use_Case;

public interface ParJoinEventOutputBoundary {
    ParJoinEventResponseModel prepareSuccessView(ParJoinEventResponseModel parJoinEventResponseModel);
    //since the regiser of the event will not fail, we only have to prepare the success view.
}