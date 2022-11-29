package use_cases.par_unfollow_org_use_case;

public class ParUnfollowOrgResponseModel {

    final String orgName;

    String message;

    public ParUnfollowOrgResponseModel(String orgName){
        this.orgName = orgName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){return this.message;}
}
