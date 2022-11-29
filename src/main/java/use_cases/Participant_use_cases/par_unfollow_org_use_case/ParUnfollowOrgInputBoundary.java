package use_cases.par_unfollow_org_use_case;

import java.sql.SQLException;

public interface ParUnfollowOrgInputBoundary {
    ParUnfollowOrgResponseModel unfollow(ParUnfollowOrgRequestModel request) throws SQLException, ClassNotFoundException;
}
