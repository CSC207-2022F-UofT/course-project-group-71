package screens.search_screens;

import par_register_event_use_case.ParRegisterEventPresenter;
import par_register_event_use_case.ParRegisterEventResponseModel;

public class ParRegisterEventResponseFormatter implements ParRegisterEventPresenter {
    @Override
    public ParRegisterEventResponseModel prepareSuccessView(ParRegisterEventResponseModel response) {
        response.setMessage("Registered successfully for " + response.getEventName() + "!");
        throw new ShowMessageView(response.getMessage());
    }
}
