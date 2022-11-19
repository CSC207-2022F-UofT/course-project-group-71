package org_delete_event_use_case;

import java.sql.SQLException;

public interface OrgDeleteEventInputBoundary {
    OrgDeleteEventResponseModel delete(OrgDeleteEventRequestModel requestModel) throws SQLException;
}
