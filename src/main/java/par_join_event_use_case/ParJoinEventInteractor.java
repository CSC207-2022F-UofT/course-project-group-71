package par_join_event_use_case;

import database.ParDsGateway;
import database.EventDsGateway;

import java.sql.SQLException;

public class ParJoinEventInteractor implements ParJoinEventInputBoundary {
    private ParJoinEventOutputBoundary presenter;
    private ParDsGateway parDsGateway;



    public ParJoinEventInteractor(ParDsGateway parDsGateway, ParJoinEventOutputBoundary presenter) {
        this.parDsGateway = parDsGateway;
        this.presenter = presenter;
    }

    @Override
    public ParJoinEventResponseModel join(ParJoinEventRequestModel request_Model) throws SQLException, ClassNotFoundException {
        parDsGateway.registerEvent(request_Model.getPar_username(),request_Model.getEvent_name());
        ParJoinEventResponseModel success = new ParJoinEventResponseModel(request_Model.getEvent_name());
        return presenter.prepareSuccessView(success);
    }






}
