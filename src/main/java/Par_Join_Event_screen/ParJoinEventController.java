package Par_Join_Event_screen;

import java.sql.SQLException;
import Par_Join_Event_Use_Case.ParJoinEventInputBoundary;
import Par_Join_Event_Use_Case.ParJoinEventRequestModel;
import Par_Join_Event_Use_Case.ParJoinEventResponseModel;

public class ParJoinEventController {

    ParJoinEventInputBoundary interactor;

    public ParJoinEventController(ParJoinEventInputBoundary interactor) {
        this.interactor = interactor;
    }

    public ParJoinEventResponseModel join(String par_username, String event_name) {
        ParJoinEventRequestModel requestModel = new ParJoinEventRequestModel(par_username, event_name);
        try {
            return interactor.join(requestModel);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}