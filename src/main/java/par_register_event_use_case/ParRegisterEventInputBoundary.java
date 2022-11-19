package par_register_event_use_case;

import java.sql.SQLException;

public interface ParRegisterEventInputBoundary {
    ParRegisterEventResponseModel register(ParRegisterEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
