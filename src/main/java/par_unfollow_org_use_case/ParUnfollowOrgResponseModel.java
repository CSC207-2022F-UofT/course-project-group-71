package par_unfollow_org_use_case;

public class ParUnfollowOrgResponseModel {

    private String orgName;

    private String message;

    public ParUnfollowOrgResponseModel(String orgName){
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
