package org_edit_event_use_case;

import java.sql.SQLException;

public interface OrgEditEventInputBoundary {
    OrgEditEventResponseModel edit(OrgEditEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
