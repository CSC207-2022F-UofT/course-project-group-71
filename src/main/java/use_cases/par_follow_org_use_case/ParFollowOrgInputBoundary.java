package use_cases.par_follow_org_use_case;

public interface ParFollowOrgInputBoundary {
    ParFollowOrgResponseModel follow(ParFollowOrgRequestModel requestModel) throws ClassNotFoundException;
}
