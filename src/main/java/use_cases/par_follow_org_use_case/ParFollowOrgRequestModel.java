package use_cases.par_follow_org_use_case;

public class ParFollowOrgRequestModel {

    String parUsername, orgUsername;

    public ParFollowOrgRequestModel(String parUsername, String orgUsername){
        this.parUsername=parUsername;
        this.orgUsername=orgUsername;
    }

    public String getParUsername() {
        return parUsername;
    }

    public String getOrgUsername() {
        return orgUsername;
    }
}
