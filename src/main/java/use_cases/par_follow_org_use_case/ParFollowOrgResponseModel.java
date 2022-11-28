package use_cases.par_follow_org_use_case;

public class ParFollowOrgResponseModel {

    String orgName;

    String message;

    ParFollowOrgResponseModel(String orgName){
        this.orgName=orgName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){return this.message;}
}
