package user_register_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegisterInteractorTest {

    void testPrepareView(){
        ParDsGateway par = new ParFileUser();
        OrgDsGateway org = new OrgFileUser();
        UserRegisterPresenter presenter = new UserRegisterPresenter();

        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                par, org, presenter);
        UserRegisterRequestModel inputData1 = new UserRegisterRequestModel("P", "",
                "allyson", "12345", "12345");
        interactor.create(inputData1);

        assertEquals("prepareFailview", );
    }


    @Test
    void create() {

        ParDsGateway par = new ParFileUser();
        OrgDsGateway org = new OrgFileUser();
        UserRegisterPresenter presenter = new UserRegisterPresenter();

        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                par, org, presenter);
        UserRegisterRequestModel inputData1 = new UserRegisterRequestModel("P", "",
                "allyson", "12345", "12345");
        interactor.create(inputData1);

    }
}