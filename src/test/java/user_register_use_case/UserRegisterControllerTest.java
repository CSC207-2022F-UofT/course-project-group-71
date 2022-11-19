package user_register_use_case;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import org.junit.jupiter.api.Test;
import screens.UserRegisterController;
import screens.UserRegisterResponseFormatter;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class UserRegisterControllerTest {

    @Test
    void testPrepareSuccessPage() throws SQLException, ClassNotFoundException {
        System.out.println("sss");
        ParDsGateway par = new ParFileUser();
        OrgDsGateway org = new OrgFileUser();

        UserRegisterResponseFormatter presenter = new UserRegisterResponseFormatter();
        UserRegisterInputBoundary interactor = new UserRegisterInteractor(par, org, presenter);
        UserRegisterController userRegisterController = new UserRegisterController(interactor);
        userRegisterController.create("P", "",
                "test", "12345", "12345");

        StackWalker walker = StackWalker.getInstance();
        Optional<String> prepareSuccessPage = walker.walk(frames -> frames
                .findFirst()
                .map(StackWalker.StackFrame::getMethodName));
        assertTrue(prepareSuccessPage.isPresent());
        assertEquals("prepareSuccessPage", prepareSuccessPage.get());
    }

    @Test
    void xxx(){
        assertEquals("sss", "sss");
    }
}