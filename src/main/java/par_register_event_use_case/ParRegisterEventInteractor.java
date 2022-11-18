package par_register_event_use_case;

import database.ParDsGateway;
import database.EventDsGateway;

import java.sql.SQLException;

public class ParRegisterEventInteractor implements ParRegisterEventInputBoundary{
    private final ParRegisterEventPresenter parRegisterEventPresenter;
    private final ParDsGateway parDsGateway;
    private final EventDsGateway eventDsGateway;

    public ParRegisterEventInteractor(ParDsGateway parDsGateway, EventDsGateway eventDsGateway, ParRegisterEventPresenter parRegisterEventPresenter) {
        this.parDsGateway = parDsGateway;
        this.eventDsGateway = eventDsGateway;
        this.parRegisterEventPresenter = parRegisterEventPresenter;
    }

    @Override
    public ParRegisterEventResponseModel register(ParRegisterEventRequestModel request_Model) throws SQLException, ClassNotFoundException {
        parDsGateway.registerEvent(request_Model.getPar_username(),request_Model.getEvent_name());
        ParRegisterEventResponseModel success = new ParRegisterEventResponseModel(request_Model.getEvent_name());
        return parRegisterEventPresenter.prepareSuccessView(success);
    }






}
