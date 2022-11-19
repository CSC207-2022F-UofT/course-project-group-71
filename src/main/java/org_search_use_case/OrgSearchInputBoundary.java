package org_search_use_case;

import java.sql.SQLException;

public interface OrgSearchInputBoundary {
    OrgSearchResponseModel orgSearch(OrgSearchRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
