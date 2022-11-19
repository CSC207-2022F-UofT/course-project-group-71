package par_search_org_use_case;

import java.sql.SQLException;

public interface ParSearchOrgInputBoundary {
    ParSearchOrgResponseModel orgSearch(ParSearchOrgRequestModel requestModel) throws SQLException, ClassNotFoundException;
}
