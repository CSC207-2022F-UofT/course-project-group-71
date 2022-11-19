package database;
import org.junit.jupiter.api.Test;
import screens.*;
import user_register_use_case_old.UserRegisterInputBoundary;
import user_register_use_case_old.UserRegisterInteractor;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class UserRegisterTest {
    @Test
    void testPrepareSuccessView() throws SQLException, ClassNotFoundException, RuntimeException {

        ParDsGateway par = new ParFileUser();
        OrgDsGateway org = new OrgFileUser();

        UserRegisterResponseFormatter presenter = new UserRegisterResponseFormatter();
        UserRegisterInputBoundary interactor = new UserRegisterInteractor(par, org, presenter);
        UserRegisterController userRegisterController = new UserRegisterController(interactor);

        try {
            userRegisterController.create("P", "",
                    "pr", "12345", "12345");

        } catch (Exception e) {

        }

        StackWalker walker = StackWalker.getInstance();
        Optional<String> prepareSuccessView = walker.walk(frames -> frames
                .findFirst()
                .map(StackWalker.StackFrame::getMethodName));
        assertTrue(prepareSuccessView.isPresent());
        assertEquals("prepareSuccessView", prepareSuccessView.get());
    }
    @Test
    void xxx(){
        assertEquals("ddd", "ddd");
    }
}
