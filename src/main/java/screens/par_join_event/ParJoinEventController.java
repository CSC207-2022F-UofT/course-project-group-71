package screens.par_join_event;

import par_join_event_use_case.ParJoinEventInputBoundary;
import par_join_event_use_case.ParJoinEventRequestModel;
import par_join_event_use_case.ParJoinEventResponseModel;

import java.sql.SQLException;


public class ParJoinEventController {

    ParJoinEventInputBoundary interactor;

    public ParJoinEventController(ParJoinEventInputBoundary interactor) {
        this.interactor = interactor;
    }

    public ParJoinEventResponseModel join(String par_username, String event_name) {
        ParJoinEventRequestModel requestModel = new ParJoinEventRequestModel(par_username, event_name);
        try {
            return interactor.join(requestModel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}