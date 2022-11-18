package par_leave_event_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

public class ParLeaveEventInteractor implements ParLeaveEventInputBoundary {

    final ParDsGateway parDsGateway;

    final OrgDsGateway orgDsGateway;

    final ParLeaveEventPresenter EventLeavePresenter;

    public ParLeaveEventInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway, ParLeaveEventPresenter eventLeavePresenter) {
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.EventLeavePresenter = eventLeavePresenter;
    }

    @Override
    public void leave(ParLeaveEventRequestModel requestModel) {
        parDsGateway.leaveEvent(requestModel.getPar_username(),requestModel.getEvent_title());
        ParLeaveEventResponseModel succesresponse = new ParLeaveEventResponseModel(requestModel.getPar_username(), requestModel.getEvent_title(),"Success to leave the event");
        EventLeavePresenter.success_view_preparation(succesresponse);
        System.out.println(1);
        return;
    }

    }

