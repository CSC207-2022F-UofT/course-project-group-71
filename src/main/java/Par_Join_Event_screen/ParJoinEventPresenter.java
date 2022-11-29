package Par_Join_Event_screen;

import Par_Join_Event_Use_Case.ParJoinEventOutputBoundary;
import Par_Join_Event_Use_Case.ParJoinEventResponseModel;

public class ParJoinEventPresenter implements ParJoinEventOutputBoundary {

    @Override
    public ParJoinEventResponseModel prepareSuccessView(ParJoinEventResponseModel response) {
        response.setMessage("Registered successfully for " + response.getEventName() + "!");
        return response;
    }
}