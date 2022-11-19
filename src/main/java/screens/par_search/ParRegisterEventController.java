package screens.par_search;

import par_register_event_use_case.ParRegisterEventInputBoundary;
import par_register_event_use_case.ParRegisterEventRequestModel;

import java.sql.SQLException;

public class ParRegisterEventController {

    final ParRegisterEventInputBoundary inputBoundary;

    public ParRegisterEventController(ParRegisterEventInputBoundary inputBoundary) {
            this.inputBoundary = inputBoundary;
        }
    public void register(String par_username, String event_name) throws SQLException, ClassNotFoundException {
        ParRegisterEventRequestModel requestModel = new ParRegisterEventRequestModel(par_username,event_name);

        inputBoundary.register(requestModel);
        }
}
