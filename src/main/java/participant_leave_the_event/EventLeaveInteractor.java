package participant_leave_the_event;

import database.OrgDsGateway;
import database.ParDsGateway;

public class EventLeaveInteractor implements EventLeaveInputBoundary{

    final ParDsGateway parDsGateway;

    final OrgDsGateway orgDsGateway;

    final EventLeavePresenter EventLeavePresenter;

    public EventLeaveInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway, EventLeavePresenter eventLeavePresenter) {
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.EventLeavePresenter = eventLeavePresenter;
    }

    @Override
    public void leave(EventLeaveRequestModel requestModel) {
        parDsGateway.leaveEvent(requestModel.getPar_username(),requestModel.getEvent_title());
        EventLeaveResponseModel succesresponse = new EventLeaveResponseModel(requestModel.getPar_username(), requestModel.getEvent_title(),"Success to leave the event");
        EventLeavePresenter.success_view_preparation(succesresponse);
        System.out.println(1);
        return;
    }

    }

