package user_login_use_case;

import controllers.UserLoginController;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import presenters.page_presenters.OrgHomePresenter;
import presenters.page_presenters.ParHomePresenter;
import presenters.use_case_presenters.UserLoginPresenter;
import use_cases.user_login_use_case.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Need to create "ass" as a participant in parfile.
 * Need to create"123" as an organization in orgfie.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserLoginTest {
    final ParDsGateway parDsGateway = new ParFileUser();
    final OrgDsGateway orgDsGateway = new OrgFileUser();
    final UserLoginOutputBoundary presenter = new UserLoginPresenter();
    final ParHomeOutputBoundary par_presenter = new ParHomePresenter();
    final OrgHomeOutputBoundary org_presenter = new OrgHomePresenter();
    final UserLoginInputBoundary interactor = new UserLoginInteractor(presenter, parDsGateway, par_presenter, orgDsGateway, org_presenter);
    final UserLoginController controller = new UserLoginController(interactor);
    UserLoginResponseModel responseModel;

    @Test
    @Order(1)
    void testPrepareFailView_ParticipantNotExist() {

        try{
            responseModel = controller.login("P","","kkk", "123123");
            assert(false);
        } catch (Exception e) {
            assertEquals("Participant does not exist.", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void testPrepareFailView_ParticipantPasswordNotMatch() {

        try{
            responseModel = controller.login("P","","aas", "123123");
            assert(false);
        } catch (Exception e) {
            assertEquals("Password doesn't match.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testPrepareFailView_OrganizerNotExist() {

        try{
            responseModel = controller.login("","O","kkk", "123123");
            assert(false);
        } catch (Exception e) {
            assertEquals("Organization does not exist.", e.getMessage());
        }
    }

    @Test
    @Order(4)
    void testPrepareFailView_OrganizerPasswordNotMatch() {

        try{
            responseModel = controller.login("","O","123", "114514");
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
    void testPrepareSuccessView_Organization() {

        try{
            responseModel = controller.login("","O","123", "123");
            assertEquals("123", responseModel.getUsername());
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    @Order(6)
    void testPrepareSuccessView_Participant() {

        try{
            responseModel = controller.login("P","","aas", "114514");
            assertEquals("aas", responseModel.getUsername());
        } catch (Exception e) {
            assert(false);
        }
    }


}
