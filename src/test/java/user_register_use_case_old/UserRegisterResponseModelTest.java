package user_register_use_case_old;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UserRegisterResponseModelTest {
    String username = "Ben";
    UserRegisterResponseModel responseModel = new UserRegisterResponseModel("Ben");

    @Test
    void getUsername(){
        assertEquals("Ben", responseModel.getUsername());
    }

    @Test
    void setUsername(){
        responseModel.setUsername("Andy");
        assertEquals("Andy", responseModel.getUsername());
    }

}
