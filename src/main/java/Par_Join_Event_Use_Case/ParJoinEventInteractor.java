package Par_Join_Event_Use_Case;

import database.ParDsGateway;

import java.sql.SQLException;

public class ParJoinEventInteractor implements ParJoinEventInputBoundary {
    ParJoinEventOutputBoundary presenter;
    ParDsGateway parDsGateway;

    /**This is the construct method of ParJoinEventInteractor.
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param presenter The presenter used to show successful view when registered successes.
     * @param parDsGateway The database gateway of the participants.
     */
    public ParJoinEventInteractor(ParDsGateway parDsGateway, ParJoinEventOutputBoundary presenter) {
        this.parDsGateway = parDsGateway;
        this.presenter = presenter;
    }

    /**Use the provided method from parDsGateway to make a participant join an upcoming event.
     * This method is called when the participant is searching for events.
     *
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the user registered for the event successfully by the presenter.
     */
    @Override
    public ParJoinEventResponseModel join(ParJoinEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.registerEvent(requestModel.getParUsername(), requestModel.getEventTitle());
        ParJoinEventResponseModel success = new ParJoinEventResponseModel(requestModel.getEventTitle());
        return presenter.prepareSuccessView(success);
    }
}