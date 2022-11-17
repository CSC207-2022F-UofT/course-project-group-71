package database;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class OrgFileUserTest {

    OrgFileUser orgFileUser = new OrgFileUser();

    @Test
    void organizerSearchTest(String about_name){
    };

    @Test
    void getPasswordTest(String username){

    };

    @Test
    void setPasswordTest(String username, String new_password){

    };

    @Test
    void getUnpublishedEventsTest(String username){

    }

    @Test
    void getPastEventsTest(String username){

    }

    @Test
    void getUpcomingEventsTest(String username){

    }

    @Test
    void getFollowersTest(String username){

    }

    @Test
    void createAnEventTest(String org_username, String title, int status, int event_type, String description,
                       String location, String image_path, int year, int month, int day, int hour, int minute){

    }

    @Test
    void deleteAnEventTest(String username, String title){

    }

    @Test
    void checkIfUsernameExistTest(String username){

    }

    @Test
    void createOrgTest(String username, String password){

    }

    @Test
    void deleteOrgTest(String username){

    }

}
