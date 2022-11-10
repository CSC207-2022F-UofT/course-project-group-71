package par_follow_org_usecase;

public class FollowOrgRequestModel {

    private String par_username, org_username;

    public FollowOrgRequestModel(String par_username, String org_username){
        this.par_username=par_username;
        this.org_username=org_username;
    }

    public String getParUsername(){
        return this.par_username;
    }

    public void setParUsername(String new_par_name){
        this.par_username= new_par_name;
    }

    public String getOrgUsername(){
        return this.org_username;
    }

    public void setOrgUsername(String new_org_name){
        this.org_username= new_org_name;
    }




}
