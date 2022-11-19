package par_leave_event_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

import java.sql.SQLException;

public class ParLeaveEventInteractor implements ParLeaveEventInputBoundary {

    final ParDsGateway parDsGateway;

    final OrgDsGateway orgDsGateway;

    final ParLeaveEventOutputBoundary parLeaveEventOutputBoundary;

    /**This is the construct method of ParLeaveEventInteractor .
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param parLeaveEventOutputBoundary The output boundary used to show successful
     *                                    view when leave event successes.
     * @param parDsGateway The database gateway of the participants.
     * @param orgDsGateway The database gateway of the organizers.
     */

    public ParLeaveEventInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway,
                                   ParLeaveEventOutputBoundary parLeaveEVentOutputBoundary) {
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.parLeaveEventOutputBoundary = parLeaveEVentOutputBoundary;
    }
    /**Use the information contained in the requestModel to check with database and respond a responseModel.
     * It took the request model and calls the registerEvent method in parDsGateway with the function
     * getPar_username and getEvent_title in the request model.
     * Then it returns the successful view by the output boundary.
     *
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the user leave the event successfully by the output boundary.
     */

    @Override
    public ParLeaveEventResponseModel leave(ParLeaveEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.leaveEvent(requestModel.getPar_username(),requestModel.getEvent_title());
        ParLeaveEventResponseModel responseModel = new ParLeaveEventResponseModel(
                requestModel.getEvent_title(),"Success to leave the event");
        return parLeaveEventOutputBoundary.prepareSuccessView(responseModel);
    }

}

