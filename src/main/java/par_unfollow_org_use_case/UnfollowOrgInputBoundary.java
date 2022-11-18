package par_unfollow_org_use_case;

import java.sql.SQLException;

public interface UnfollowOrgInputBoundary {
    void follow(UnfollowOrgRequestModel request) throws SQLException, ClassNotFoundException;
}
