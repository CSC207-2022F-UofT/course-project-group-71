package use_cases.par_unfollow_org_use_case;

public interface ParUnfollowOrgInputBoundary {
    ParUnfollowOrgResponseModel unfollow(ParUnfollowOrgRequestModel request) throws ClassNotFoundException;
}
