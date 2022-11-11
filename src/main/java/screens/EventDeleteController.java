package screens;

import org_delete_use_case.EventDeleteResponseModel;
import org_delete_use_case.EventDeleteInputBoundary;
import org_delete_use_case.EventDeleteRequestModel;

public class EventDeleteController {
    final EventDeleteInputBoundary userInput;

    public EventDeleteController(EventDeleteInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    EventDeleteResponseModel delete(String eventName) {
        EventDeleteRequestModel requestModel = new EventDeleteRequestModel(eventName);
        return userInput.delete(requestModel);
    }
}