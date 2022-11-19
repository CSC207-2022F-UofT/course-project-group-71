package database;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import screens.*;
import screens.org_home.OrgHomeResponseFormatter;
import screens.par_home.ParHomeResponseFormatter;
import user_login_use_case.*;
import user_register_use_case.UserRegisterInputBoundary;
import user_register_use_case.UserRegisterInteractor;
import user_register_use_case.UserRegisterResponseModel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class UserRegisterTest {
    ParDsGateway par = new ParFileUser();
    OrgDsGateway org = new OrgFileUser();

    UserRegisterResponseFormatter presenter = new UserRegisterResponseFormatter();
    UserRegisterInputBoundary interactor = new UserRegisterInteractor(par, org, presenter);
    UserRegisterController userRegisterController = new UserRegisterController(interactor);

    UserRegisterResponseModel responseModel = null;
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
            System.out.println(responseModel.getMessage());
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
    void testPrepareSuccessView_Participant() {
        try {
            responseModel = userRegisterController.create("P", "",
                    "a", "12345", "12345");
            System.out.println(responseModel.getMessage());
            assert (false);
        } catch (Exception e) {
            assertEquals("Participant already exists.", e.getMessage());
        }
    }
    @Test
    @Order(7)
    void testPrepareFailView_ParticipantExists(){
        try {
            responseModel = userRegisterController.create("P", "",
                    "a", "12345", "12345");
            assertEquals("a, you can login now!", responseModel.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert(false);
        }
    }
    @Test
    @Order(8)
    void testPrepareFailView_ParticipantPasswordEmpty(){
        try {
            responseModel = userRegisterController.create("P", "",
                    "2", "", "");
            System.out.println(responseModel.getMessage());
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


}
