package Par_Join_Event_Use_Case;

import database.ParDsGateway;

import java.sql.SQLException;

public class ParJoinEventInteractor implements ParJoinEventInputBoundary {
    ParJoinEventOutputBoundary presenter;
    ParDsGateway parDsGateway;


    @Override
    public ParJoinEventResponseModel join(ParJoinEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.registerEvent(requestModel.getParUsername(), requestModel.getEventTitle());
        ParJoinEventResponseModel success = new ParJoinEventResponseModel(requestModel.getEventTitle());
        return presenter.prepareSuccessView(success);
    }
}