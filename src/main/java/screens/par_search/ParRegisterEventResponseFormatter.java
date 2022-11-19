package screens.par_search;

import par_join_event_use_case.ParJoinEventOutputBoundary;
import par_join_event_use_case.ParJoinEventResponseModel;
import screens.*;
public class ParRegisterEventResponseFormatter implements ParJoinEventOutputBoundary {
    @Override
    public ParJoinEventResponseModel prepareSuccessView(ParJoinEventResponseModel response) {
        response.setMessage("Joined successfully for " + response.getEventName() + "!");
        throw new ShowMessageView(response.getMessage());
    }
}
