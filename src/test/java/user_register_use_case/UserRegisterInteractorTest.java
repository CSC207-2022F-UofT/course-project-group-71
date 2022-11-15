package user_register_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegisterInteractorTest {

    @Test
    void create() {

        ParDsGateway par = new ParFileUser();
        OrgDsGateway org = new OrgFileUser();
        UserRegisterPresenter presenter = new UserRegisterPresenter() {
            @Override
            public UserRegisterResponseModel prepareFailView(String failureresponse) {
                fail("Use case failure is unexpected.");
                return null;
            }

            @Override
            public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user) {
                assertEquals("allyson", user.getUsername());
                assertTrue(par.checkIfUsernameExist("allyson"));
                return null;
            }
        };

        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                par, org, presenter);
        UserRegisterRequestModel inputData1 = new UserRegisterRequestModel("P", "",
                "allyson", "12345", "12345");
        interactor.create(inputData1);

    }
}