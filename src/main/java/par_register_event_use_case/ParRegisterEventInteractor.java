package par_register_event_use_case;

import database.ParDsGateway;
import database.EventDsGateway;

public class ParRegisterEventInteractor implements ParRegisterEventInputBoundary{
    private final ParRegisterEventPresenter parRegisterEventPresenter;
    private final ParDsGateway parDsGateway;
    private final EventDsGateway eventDsGateway;

    /**This is the construct method of ParRegisterEventInteractor.
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param parRegisterEventPresenter The presenter used to show successful view when registered successes.
     * @param parDsGateway The database gateway of the participants.
     * @param eventDsGateway The database gateway of the events.
     */

    public ParRegisterEventInteractor(ParDsGateway parDsGateway, EventDsGateway eventDsGateway, ParRegisterEventPresenter parRegisterEventPresenter) {
        this.parDsGateway = parDsGateway;
        this.eventDsGateway = eventDsGateway;
        this.parRegisterEventPresenter = parRegisterEventPresenter;
    }
    /**Use the information contained in the requestModel to check with database and respond a responseModel.
     * It took the request model and calls the registerEvent method in parDsGateway with the function
     * getPar_username and getEvent_name in the request model.
     * Then it returns the successful view by the presenter
     *
     * @param request_Model The request model sent to this interactor.
     * @return A responseModel representing the user registered for the event successfully by the presenter.
     */
    @Override
    public ParRegisterEventResponseModel register(ParRegisterEventRequestModel request_Model) {
        parDsGateway.registerEvent(request_Model.getPar_username(),request_Model.getEvent_name());
        ParRegisterEventResponseModel success = new ParRegisterEventResponseModel(request_Model.getEvent_name());
        return parRegisterEventPresenter.prepareSuccessView(success);
    }






}
