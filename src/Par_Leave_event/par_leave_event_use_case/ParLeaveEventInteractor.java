package par_leave_event_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

import java.sql.SQLException;

public class ParLeaveEventInteractor implements ParLeaveEventInputBoundary {

    ParDsGateway parDsGateway;

    OrgDsGateway orgDsGateway;

    ParLeaveEventOutputBoundary parLeaveEventOutputBoundary;

    /**Constructor
     *
     * @param parLeaveEventOutputBoundary The output boundary used to show successful view when leave event succeeds.
     * @param parDsGateway The database gateway of the participants.
     * @param orgDsGateway The database gateway of the organizers.
     */
    public ParLeaveEventInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway,
                                   ParLeaveEventOutputBoundary parLeaveEventOutputBoundary) {
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.parLeaveEventOutputBoundary = parLeaveEventOutputBoundary;
    }

    /**Use the provided method from parDsGateway to make a participant leave an upcoming event.
     * Precondition: the participant joined the upcoming event
     *
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the user leave the event successfully by the output boundary.
     */
    @Override
    public ParLeaveEventResponseModel leave(ParLeaveEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        parDsGateway.leaveEvent(requestModel.getPar_username(), requestModel.getEvent_title());
        ParLeaveEventResponseModel responseModel = new ParLeaveEventResponseModel(requestModel.getEvent_title());
        return parLeaveEventOutputBoundary.prepareSuccessView(responseModel);
    }

}

