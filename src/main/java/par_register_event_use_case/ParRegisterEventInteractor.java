package par_register_event_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;
import database.EventDsGateway;

public class ParRegisterEventInteractor implements ParRegisterEventInputBoundary{
    private ParRegisterEventPresenter parRegisterEventPresenter;
    private ParDsGateway parDsGateway;
    private EventDsGateway eventDsGateway;
    private ParRegisterEventPresenter parRegisterEventPresenter;

    public ParRegisterEventInteractor(ParDsGateway parDsGateway, EventDsGateway eventDsGateway, ParRegisterEventPresenter parRegisterEventPresenter) {
        this.parDsGateway = parDsGateway;
        this.eventDsGateway = eventDsGateway;
        this.ParRegisterEventPresenter = parRegisterEventPresenter;
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
