package screens;

import org_delete_use_case.EventDeleteResponseModel;
import org_delete_use_case.EventDeletePresenter;

public class EventDeleteResponseFormatter implements EventDeletePresenter {
    @Override
    public EventDeleteResponseModel prepareSuccessView(EventDeleteResponseModel response) {
        response.setMessage("Event" + response.getEventName() + "deleted");
        return response;
    }
}
