package org_create_event_use_case;

import java.sql.SQLException;

public interface OrgCreateEventInputBoundary {
    OrgCreateEventResponseModel create(OrgCreateEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
