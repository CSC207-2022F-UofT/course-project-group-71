package user_login_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import screens.UserLoginController;
import screens.UserLoginPresenter;
import screens.org_home.OrgHomePresenter;
import screens.par_home.ParHomePresenter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserLoginTest {
    ParDsGateway parDsGateway = new ParFileUser();

    OrgDsGateway orgDsGateway = new OrgFileUser();

    UserLoginOutputBoundary presenter = new UserLoginPresenter();

    ParHomeOutputBoundary par_presenter = new ParHomePresenter();

    OrgHomeOutputBoundary org_presenter = new OrgHomePresenter();

    UserLoginInputBoundary interactor = new UserLoginInteractor(presenter, parDsGateway, par_presenter, orgDsGateway, org_presenter);

    UserLoginController controller = new UserLoginController(interactor);

    UserLoginResponseModel responseModel = null;

    @Test
    @Order(1)
    void testPrepareFailView_ParticipantNotExist() {

        try{
            responseModel = controller.login("0","","kkk", "123123");
            assert(false);
        } catch (Exception e) {
            assertEquals("Participant does not exist.", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void testPrepareFailView_ParticipantPasswordNotMatch() {

        try{
            responseModel = controller.login("0","","aas", "123123");
            assert(false);
        } catch (Exception e) {
            assertEquals("Password doesn't match.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testPrepareFailView_OrganizerNotExist() {

        try{
            responseModel = controller.login("","0","kkk", "123123");
            assert(false);
        } catch (Exception e) {
            assertEquals("Organization does not exist.", e.getMessage());
        }
    }

    @Test
    @Order(4)
    void testPrepareFailView_OrganizerPasswordNotMatch() {

        try{
            responseModel = controller.login("0","","123", "114514");
            assert(false);
        } catch (Exception e) {
            assertEquals("Password doesn't match.", e.getMessage());
        }
    }

    @Test
    @Order(5)
    void testPrepareFailView_UserMissType() {

        try{
            responseModel = controller.login("","","123", "114514");
            assert(false);
        } catch (Exception e) {
            assertEquals("Please select your account type.", e.getMessage());
        }
    }

    @Test
    @Order(6)
    void testPrepareSuccessView_Orgnization() {

        try{
            responseModel = controller.login("","0","123", "123");
            assertEquals("", responseModel.getUsername());
        } catch (Exception e) {
            assert(false);
        }
    }


}
