package user_register_use_case;

import controller_presenter_view.screens.user_register.UserRegisterController;
import controller_presenter_view.screens.user_register.UserRegisterPresenter;
import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import use_cases.user_register_use_case.UserRegisterInputBoundary;
import use_cases.user_register_use_case.UserRegisterInteractor;
import use_cases.user_register_use_case.UserRegisterResponseModel;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Do not need prior data, an empty mysql file is the best
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRegisterTest {
    final ParDsGateway par = new ParFileUser();
    final OrgDsGateway org = new OrgFileUser();
    final UserRegisterPresenter presenter = new UserRegisterPresenter();
    final UserRegisterInputBoundary interactor = new UserRegisterInteractor(par, org, presenter);
    final UserRegisterController userRegisterController = new UserRegisterController(interactor);
    UserRegisterResponseModel responseModel;


    @Test
    @Order(1)
    void testPrepareFailView_ParticipantMissingType(){

        try {
            responseModel = userRegisterController.create("", "",
                    "1", "12345", "12345");
            assert(false);
        } catch (Exception e) {
            assertEquals("Please select your account type.", e.getMessage());
        }
    }
    @Test
    @Order(2)
    void testPrepareSuccessView_Organization(){
        try {
            responseModel = userRegisterController.create("", "O",
                    "1", "12345", "12345");
            TimeUnit.SECONDS.sleep(3);
            assertEquals("1, you can login now!", responseModel.getMessage());
        } catch (Exception e) {
            assert(false);
        }
    }
    @Test
    @Order(3)
    void testPrepareFailView_OrganizationExists(){
        try {
            responseModel = userRegisterController.create("", "O",
                    "1", "12345", "12345");
            assert(false);
        } catch (Exception e) {
            assertEquals("Organization already exists.", e.getMessage());
        }
    }
    @Test
    @Order(4)
    void testPrepareFailView_OrganizationPasswordEmpty(){
        try {
            responseModel = userRegisterController.create("", "O",
                    "2", "", "");
            assert(false);
        } catch (Exception e) {
            assertEquals("Password cannot be empty.", e.getMessage());
        }
    }
    @Test
    @Order(5)
    void testPrepareFailView_OrganizationPasswordNotMatch(){
        try {
            responseModel = userRegisterController.create("", "O",
                    "2", "1234", "12345");
            assert(false);
        } catch (Exception e) {
            assertEquals("Two Passwords are different.", e.getMessage());
        }
    }
    @Test
    @Order(6)
    void testPrepareSuccessView_Participant(){
        try {
            responseModel = userRegisterController.create("P", "",
                    "1", "12345", "12345");
            assertEquals("1, you can login now!", responseModel.getMessage());
        } catch (Exception e) {
            assert(false);
        }
    }
    @Test
    @Order(7)
    void testPrepareFailView_ParticipantExists(){
        try {
            TimeUnit.SECONDS.sleep(10);
            responseModel = userRegisterController.create("P", "",
                    "1", "12345", "12345");
            TimeUnit.SECONDS.sleep(10);
            assert(false);
        } catch (Exception e) {
            assertEquals("Participant already exists.", e.getMessage());
        }
    }
    @Test
    @Order(8)
    void testPrepareFailView_ParticipantPasswordEmpty(){
        try {
            responseModel = userRegisterController.create("P", "",
                    "2", "", "");
            assert(false);
        } catch (Exception e) {

            assertEquals("Password cannot be empty.", e.getMessage());
        }
    }
    @Test
    @Order(9)
    void testPrepareFailView_ParticipantPasswordNotMatch(){
        try {
            responseModel = userRegisterController.create("P", "",
                    "2", "1234", "12345");
            assert(false);
        } catch (Exception e) {
            assertEquals("Two Passwords are different.", e.getMessage());
        }
    }

    @Test
    @Order(10)
    void testTooLongParUsername(){
        try {
            responseModel = userRegisterController.create("P", "",
                    "1111111111111111111111111111111111111111111","123","123");
        } catch (Exception e) {
            assertEquals("Username should be no longer than 20 characters.", e.getMessage());

        }
    }

    @Test
    @Order(11)
    void testTooLongParPassword(){
        try {
            responseModel = userRegisterController.create("P", "",
                    "1234","1111111111111111111111111111111111111111111","123");
        } catch (Exception e) {
            assertEquals("Password should be no longer than 20 characters.", e.getMessage());

        }
    }

    @Test
    @Order(12)
    void testTooLongOrgUsername(){
        try {
            responseModel = userRegisterController.create("P", "O",
                    "1111111111111111111111111111111111111111111","123","123");
        } catch (Exception e) {
            assertEquals("Username should be no longer than 20 characters.", e.getMessage());

        }
    }

    @Test
    @Order(13)
    void testTooLongOrgPassword(){
        try {
            responseModel = userRegisterController.create("", "O",
                    "1234","1111111111111111111111111111111111111111111","123");
        } catch (Exception e) {
            assertEquals("Password should be no longer than 20 characters.", e.getMessage());

        }
    }


}
