package par_join_event_use_case;

import database.ParDsGateway;
import database.EventDsGateway;

import java.sql.SQLException;

public class ParJoinEventInteractor implements ParJoinEventInputBoundary {
    private ParJoinEventOutputBoundary presenter;
    private ParDsGateway parDsGateway;

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
    /**Use the information contained in the requestModel to check with database and respond a responseModel.
     * It took the request model and calls the registerEvent method in parDsGateway with the function
     * getPar_username and getEvent_name in the request model.
     * Then it returns the successful view by the presenter.
     *
     * @param request_Model The request model sent to this interactor.
     * @return A responseModel representing the user registered for the event successfully by the presenter.
     */
    @Override
    public ParJoinEventResponseModel join(ParJoinEventRequestModel request_Model) throws SQLException, ClassNotFoundException {
        parDsGateway.registerEvent(request_Model.getPar_username(),request_Model.getEvent_name());
        //This calls the registerevent method in the parDsGateway which took the user name and the event name to
        // modify the participant database.
        ParJoinEventResponseModel success = new ParJoinEventResponseModel(request_Model.getEvent_name());
        return presenter.prepareSuccessView(success);
    }






}
