package screens.par_search;

import par_join_event_use_case.ParJoinEventInputBoundary;
import par_join_event_use_case.ParJoinEventRequestModel;

import java.sql.SQLException;

public class ParRegisterEventController {

    final ParJoinEventInputBoundary inputBoundary;

    public ParRegisterEventController(ParJoinEventInputBoundary inputBoundary) {
            this.inputBoundary = inputBoundary;
        }
    public void register(String par_username, String event_name) throws SQLException, ClassNotFoundException {
        ParJoinEventRequestModel requestModel = new ParJoinEventRequestModel(par_username,event_name);

        inputBoundary.join(requestModel);
        }
}
