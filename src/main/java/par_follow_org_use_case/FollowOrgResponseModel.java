package par_follow_org_use_case;

public class FollowOrgResponseModel {

    private String orgName;

    public FollowOrgResponseModel(String orgName){
        this.orgName=orgName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
