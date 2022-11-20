package user_reset_password_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import screens.org_account.OrgResetPasswordController;
import screens.org_account.OrgResetPasswordPresenter;
import screens.par_account.ParResetPasswordController;
import screens.par_account.ParResetPasswordPresenter;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Before using the test, click and open Datagrip
 * Create a localhost, create a database called testing_db
 * Then right clicks testing_db, choose import/export, click restore from mysqldump
 * Choose the mysql.exe file from the file explorer
 * And set the file path to the testing_db.sql in sql_file_to_import package next to this class
 * Click Import to import all the tables in, the testing database are set after this
 *
 */
public class UserResetPasswordTest {
    ParDsGateway parDsGateway = new ParFileUser();
    OrgDsGateway orgDsGateway = new OrgFileUser();

    UserResetPasswordOutputBoundary org_presenter = new OrgResetPasswordPresenter();
    UserResetPasswordOutputBoundary par_presenter = new ParResetPasswordPresenter();


    UserResetPasswordInputBoundary interactor_org = new UserResetPasswordInteractor(org_presenter, orgDsGateway, parDsGateway);
    UserResetPasswordInputBoundary interactor_par = new UserResetPasswordInteractor(par_presenter, orgDsGateway, parDsGateway);

    OrgResetPasswordController orgController = new OrgResetPasswordController(interactor_org);
    ParResetPasswordController parController = new ParResetPasswordController(interactor_par);


    UserResetPasswordResponseModel responseModel = null;

    @Test
    @Order(1)
    void testPrepareFailureView_Org_Incorrect_Password(){
        try {
            responseModel = orgController.resetPassword("O1", "fake_password",
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
            responseModel = orgController.resetPassword("O1", "O1password",
                    "temp_new", "temp_new");
            System.out.println("Password reset successfully!");
            System.out.println(responseModel.getMessage());
            assertEquals("Password reset successfully!", responseModel.getMessage());
            orgController.resetPassword("O1", "temp_new", "O1password","O1password");
        } catch (SQLException | ClassNotFoundException e) {
            assert(false);
        }
    }

    @Test
    @Order(3)
    void testPrepareFailureView_Org_New_Password_Not_Match(){
        try {
            responseModel = orgController.resetPassword("O1", "O1password", "temp1", "temp2");
            assert(false);
        } catch (Exception e) {
            assertEquals("New Passwords do not match.", e.getMessage());
        }
    }

    @Test
    @Order(4)
    void testPrepareFailureView_Par_Incorrect_Password(){
        try {
            responseModel = parController.resetPassword("P2","fake_password","temp_password","temp_password");
            assert(false);
        } catch (Exception e) {
            assertEquals("Old password is not correct.", e.getMessage());
        }
    }

    @Test
    @Order(5)
    void testPrepareSuccessView_Par(){
        try {
            responseModel = parController.resetPassword("P2","p2","temp_password","temp_password");
            assertEquals("Password reset successfully!", responseModel.getMessage());
            parController.resetPassword("P2", "temp_password","p2","p2");
        } catch (SQLException | ClassNotFoundException e) {
            assert(false);
        }
    }

    @Test
    @Order(6)
    void testPrepareFailureView_Par_New_Password_Not_Match() {
        try {
            responseModel = parController.resetPassword("P2", "p2", "temp1", "temp2");
            assert (false);
        } catch (Exception e) {
            assertEquals("New Passwords do not match.", e.getMessage());
        }

    }
}
