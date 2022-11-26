package par_unfollow_org_use_case;

public class ParUnfollowOrgRequestModel {

    String par_username, org_username;

    public ParUnfollowOrgRequestModel(String par_username, String org_username){
        this.par_username = par_username;
        this.org_username = org_username;
    }

    public String getPar_username() {
        return par_username;
    }

    public String getOrg_username() {
        return org_username;
    }
}
