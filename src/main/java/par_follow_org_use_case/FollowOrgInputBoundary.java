package par_follow_org_use_case;

import java.sql.SQLException;

public interface FollowOrgInputBoundary {
    FollowOrgResponseModel follow(FollowOrgRequestModel request) throws SQLException, ClassNotFoundException;
}
