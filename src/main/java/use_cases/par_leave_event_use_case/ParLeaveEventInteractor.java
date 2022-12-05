package use_cases.par_leave_event_use_case;

import database.ParDsGateway;

public class ParLeaveEventInteractor implements ParLeaveEventInputBoundary {

    final ParDsGateway parDsGateway;
    
    final ParLeaveEventOutputBoundary parLeaveEventOutputBoundary;

    /**Constructor
     *
     * @param parLeaveEventOutputBoundary The output boundary used to show successful view when leave event succeeds.
     * @param parDsGateway The database gateway of the participants.
     * */
    public ParLeaveEventInteractor(ParDsGateway parDsGateway,
                                   ParLeaveEventOutputBoundary parLeaveEventOutputBoundary) {
        this.parDsGateway = parDsGateway;
        this.parLeaveEventOutputBoundary = parLeaveEventOutputBoundary;
    }

    /**Use the provided method from parDsGateway to make a participant leave an upcoming event.
     * Precondition: the participant joined the upcoming event
     *
     * @param requestModel The request model sent to this interactor.
     * @return A responseModel representing the user leave the event successfully by the output boundary.
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    @Override
    public ParLeaveEventResponseModel leave(ParLeaveEventRequestModel requestModel) throws ClassNotFoundException {
        parDsGateway.leaveEvent(requestModel.getPar_username(), requestModel.getEvent_title());
        ParLeaveEventResponseModel responseModel = new ParLeaveEventResponseModel(requestModel.getEvent_title());
        return parLeaveEventOutputBoundary.prepareSuccessView(responseModel);
    }

}

