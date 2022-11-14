package par_register_event_use_case;

public interface ParRegisterEventInputBoundary {
    ParRegisterEventResponseModel Register(ParRegisterEventRequestModel requestModel);
}
