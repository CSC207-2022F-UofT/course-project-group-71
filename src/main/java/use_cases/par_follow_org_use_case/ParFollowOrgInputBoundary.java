package use_cases.par_follow_org_use_case;

import java.sql.SQLException;

public interface ParFollowOrgInputBoundary {
    ParFollowOrgResponseModel follow(ParFollowOrgRequestModel requestModel) throws ClassNotFoundException;
}
