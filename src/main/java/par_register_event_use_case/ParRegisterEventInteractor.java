package par_register_event_use_case;

import database.ParDsGateway;
import database.EventDsGateway;

public class ParRegisterEventInteractor implements ParRegisterEventInputBoundary{
    private final ParRegisterEventPresenter parRegisterEventPresenter;
    private final ParDsGateway parDsGateway;

    public ParRegisterEventInteractor(ParDsGateway parDsGateway, EventDsGateway eventDsGateway, ParRegisterEventPresenter parRegisterEventPresenter) {
        this.parDsGateway = parDsGateway;
        this.parRegisterEventPresenter = parRegisterEventPresenter;
    }

    @Override
    public ParRegisterEventResponseModel register(ParRegisterEventRequestModel request_Model) {
        parDsGateway.registerEvent(request_Model.getPar_username(),request_Model.getEvent_name());
        return parRegisterEventPresenter.prepareSuccessView();
    }






}
