package controller_presenter_view.common_controller_presenter.par_leave_event;

import par_leave_event_use_case.ParLeaveEventInputBoundary;
import par_leave_event_use_case.ParLeaveEventRequestModel;
import par_leave_event_use_case.ParLeaveEventResponseModel;

import java.sql.SQLException;

public class ParLeaveEventController {

    final ParLeaveEventInputBoundary interactor;

    /**The constructor method of ParLeaveEventController, it takes an interactor object as input and store it as instance.
     *
     * @param interactor ParLeaveEventInputBoundary inputed
     */
    public ParLeaveEventController(ParLeaveEventInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**The method calling interactor to get a responsemodel.
     * It makes a participant leave the event.
     *
     * @param par_username The username of participant who want to leave an event
     * @param event_title The title of the event that want to be leaved from
     * @return The responsemodel sent back from interactor
     * @throws SQLException The Exception happened when a SQL error occurs
     * @throws ClassNotFoundException The Exception happened when Class is not found
     */
    public ParLeaveEventResponseModel leave(String par_username, String event_title) throws SQLException, ClassNotFoundException {
        ParLeaveEventRequestModel requestModel = new ParLeaveEventRequestModel(par_username,event_title);
        return interactor.leave(requestModel);
    }
}
