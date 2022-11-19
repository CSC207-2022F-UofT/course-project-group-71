package user_register_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UserRegisterRequestModelTest {
    String isParticipant = "P";
    String isOrganization = "";
    String name = "Ben";
    String password = "1234";
    String re_password = "1234";

    UserRegisterRequestModel requestmodel = new UserRegisterRequestModel(isParticipant,isOrganization,name,password,re_password){

    };

    @Test
    void getName() {
        assertEquals("P", requestmodel.getUserType());
        assertEquals("Ben", requestmodel.getName());
        assertEquals("1234", requestmodel.getPassword());
        assertEquals("1234", requestmodel.getRe_password());

    }


}
