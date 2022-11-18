package par_follow_org_usecase;

public class FollowOrgController {

    final FollowOrgInputBoundary interactor;
    public FollowOrgController(FollowOrgInputBoundary interactor){
        this.interactor= interactor;
    }

    public void follow(String par_username, String org_username){
        FollowOrgRequestModel request= new FollowOrgRequestModel(par_username,org_username);
    }

}
