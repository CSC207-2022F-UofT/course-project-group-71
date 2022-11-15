package screens.par_home;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import screens.LoginPage;
import screens.org_home.OrgHomeResponseFormatter;
import screens.UserLoginController;
import screens.UserLoginResponseFormatter;
import screens.par_account.ParAccountPage;
import screens.par_followed_org.ParFollowedOrgPage;
import screens.par_past_event.ParPastEventPage;
import screens.par_upcoming_event.ParUpcomingEventPage;
import user_login_use_case.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParHomeActionListener implements ActionListener {
    public ParHomePage parHomePage;
    public ParHomeActionListener(ParHomePage parHomePage){
        this.parHomePage = parHomePage;
    }


    public void actionPerformed(ActionEvent arg0){
        String page = arg0.getActionCommand();

        if (page.equals("Account")) {
            this.parHomePage.dispose();
            new ParAccountPage(this.parHomePage.getParUsername());
        }
        else if (page.equals("Upcoming Event")) {
            this.parHomePage.dispose();
            new ParUpcomingEventPage(this.parHomePage.getParUsername());
        }
        else if (page.equals("Past Event")) {
            this.parHomePage.dispose();
            new ParPastEventPage(this.parHomePage.getParUsername());
        }
        else if (page.equals("Followed Org")){
            this.parHomePage.dispose();
            new ParFollowedOrgPage(this.parHomePage.getParUsername());
        }
        else if( page.equals("Search")){
            this.parHomePage.dispose();
            if(this.parHomePage.org.isSelected()){

            }
            else{

            }
        }


        else {
            this.parHomePage.dispose();
            UserLoginPresenter userLoginPresenter =  new UserLoginResponseFormatter();

            ParDsGateway parDsGateway = new ParFileUser();

            ParHomePresenter parHomePresenter =  new ParHomeResponseFormatter();

            OrgDsGateway orgDsGateway= new OrgFileUser();

            OrgHomePresenter orgHomePresenter =  new OrgHomeResponseFormatter();

            UserLoginInputBoundary interactor = new UserLoginInteractor(
                    userLoginPresenter, parDsGateway, parHomePresenter, orgDsGateway, orgHomePresenter);

            UserLoginController userLoginController = new UserLoginController(interactor);

            new LoginPage(userLoginController);
        }
    }
}
