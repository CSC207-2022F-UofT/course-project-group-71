package par_follow_org_use_case;

import java.sql.SQLException;

public interface ParFollowOrgInputBoundary {
    ParFollowOrgResponseModel follow(ParFollowOrgRequestModel request) throws SQLException, ClassNotFoundException;
}
