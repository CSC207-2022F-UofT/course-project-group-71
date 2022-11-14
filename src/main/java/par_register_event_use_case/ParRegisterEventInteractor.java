package par_register_event_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;
import database.EventDsGateway;

public class ParRegisterEventInteractor implements ParRegisterEventInputBoundary{
    private ParRegisterEventPresenter parRegisterEventPresenter;
    private final ParDsGateway parDsGateway;
    private final EventDsGateway eventDsGateway;
    private ParRegisterEventPresenter parRegisterEventPresenter;

    public ParRegisterEventInteractor(ParDsGateway parDsGateway, EventDsGateway eventDsGateway, ParRegisterEventPresenter parRegisterEventPresenter) {
        this.parDsGateway = parDsGateway;
        this.eventDsGateway = eventDsGateway;
        this.parRegisterEventPresenter = parRegisterEventPresenter;
    }

    @Override
    public ParRegisterEventResponseModel register(ParRegisterEventRequestModel request_Model) {
        parDsGateway.registerEvent(request_Model.getPar_username(),request_Model.getEvent_name());
        return parRegisterEventPresenter.prepareRegisterSuccess()
    }






}
