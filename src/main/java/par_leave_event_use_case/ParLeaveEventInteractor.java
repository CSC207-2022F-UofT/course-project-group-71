package par_leave_event_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

import java.sql.SQLException;

public class ParLeaveEventInteractor implements ParLeaveEventInputBoundary {

    final ParDsGateway parDsGateway;

    final OrgDsGateway orgDsGateway;

    final ParLeaveEventOutputBoundary parLeaveEventOutputBoundary;

    public ParLeaveEventInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway,
                                   ParLeaveEventOutputBoundary parLeaveEVentOutputBoundary) {
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.parLeaveEventOutputBoundary = parLeaveEVentOutputBoundary;
    }

    @Override
    public ParLeaveEventResponseModel leave(ParLeaveEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.leaveEvent(requestModel.getPar_username(),requestModel.getEvent_title());
        ParLeaveEventResponseModel responseModel = new ParLeaveEventResponseModel(
                requestModel.getEvent_title(),"Success to leave the event");
        return parLeaveEventOutputBoundary.prepareSuccessView(responseModel);
    }

}

