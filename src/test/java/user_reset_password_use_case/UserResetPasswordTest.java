package user_reset_password_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import screens.org_account.OrgResetPasswordController;
import screens.par_account.ParResetPasswordController;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserResetPasswordTest {
    ParDsGateway parDsGateway = new ParFileUser();
    OrgDsGateway orgDsGateway = new OrgFileUser();

    UserResetPasswordPresenter presenter = new UserResetPasswordFormatter();
    UserResetPasswordInputBoundary interactor = new UserResetPasswordInteractor(presenter, orgDsGateway, parDsGateway);

    OrgResetPasswordController orgcontroller = new OrgResetPasswordController(interactor);
    ParResetPasswordController parcontroller = new ParResetPasswordController(interactor);


    UserResetPasswordResponseModel responseModel = null;

    @Test
    @Order(1)
    void testPrepareFailureView_Org_Incorrect_Password(){
        try {
            responseModel = orgcontroller.resetPassword("O1", "fake_password",
                    "temp_new", "temp_new");
            assert(false);
        } catch (Exception e) {
            assertEquals("Old password is not correct.", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void testPrepareSuccessView_Org() {
        try {
            responseModel = orgcontroller.resetPassword("O1", "O1password",
                    "temp_new", "temp_new");
            System.out.println("Password reset successfully!");
            System.out.println(responseModel.getMessage());
            assertEquals("Password reset successfully!", responseModel.getMessage());
            orgcontroller.resetPassword("O1", "temp_new", "O1password","O1password");
        } catch (SQLException | ClassNotFoundException e) {
            assert(false);
        }
    }

    @Test
    @Order(3)
    void testPrepareFailureView_Org_New_Password_Not_Match(){
        try {
            responseModel = orgcontroller.resetPassword("O1", "O1password", "temp1", "temp2");
            assert(false);
        } catch (Exception e) {
            assertEquals("New Passwords do not match.", e.getMessage());
        }
    }

    @Test
    @Order(4)
    void testPrepareFailureView_Par_Incorrect_Password(){
        try {
            responseModel = parcontroller.resetPassword("P2","fake_password","temp_password","temp_password");
            assert(false);
        } catch (Exception e) {
            assertEquals("Old password is not correct.", e.getMessage());
        }
    }

    @Test
    @Order(5)
    void testPrepareSuccessView_Par(){
        try {
            responseModel = parcontroller.resetPassword("P2","p2","temp_password","temp_password");
            assertEquals("Password reset successfully!", responseModel.getMessage());
            parcontroller.resetPassword("P2", "temp_password","p2","p2");
        } catch (SQLException | ClassNotFoundException e) {
            assert(false);
        }
    }

    @Test
    @Order(6)
    void testPrepareFailureView_Par_New_Password_Not_Match() {
        try {
            responseModel = parcontroller.resetPassword("P2", "p2", "temp1", "temp2");
            assert (false);
        } catch (Exception e) {
            assertEquals("New Passwords do not match.", e.getMessage());
        }

    }
}
