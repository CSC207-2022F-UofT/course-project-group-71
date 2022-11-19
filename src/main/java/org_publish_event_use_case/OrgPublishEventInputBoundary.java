package org_publish_event_use_case;

import java.sql.SQLException;

public interface OrgPublishEventInputBoundary {

    OrgPublishEventResponseModel publish(OrgPublishEventRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
