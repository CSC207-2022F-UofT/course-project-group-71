package upcoming_to_past_use_case;

import java.sql.SQLException;

public interface UpcomingToPastInputBoundary {
    UpcomingToPastResponseModel convertToPast(UpcomingToPastRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
