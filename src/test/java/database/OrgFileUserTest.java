package database;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrgFileUserTest {

    OrgFileUser orgFileUser = new OrgFileUser();

    @Test
    void testGetPassword(){
        assertEquals("O1password",orgFileUser.getPassword("O1"));
        assertEquals("O2password",orgFileUser.getPassword("O2"));
        assertEquals("O3password",orgFileUser.getPassword("O3"));
    }

    @Test
    void testSetPassword(){

    }

    @Test
    void testGetUnpublishedEvents(){
        ArrayList<String> l1 = new ArrayList<>(List.of("E1"));
        assertEquals(l1,orgFileUser.getUnpublishedEvents("O1"));
    }

    @Test
    void testGetPastEvents(){
        ArrayList<String> l1 = new ArrayList<>(List.of("E3"));
        assertEquals(l1,orgFileUser.getPastEvents("O1"));
    }

    @Test
    void testGetUpcomingEvents(){
        ArrayList<String> l1 = new ArrayList<>(List.of("E2", "E4"));
        assertEquals(l1,orgFileUser.getUpcomingEvents("O1"));
    }

    @Test
    void testGetFollowers(){
        ArrayList<String> l1 = new ArrayList<>(List.of("P1","P2","P3","P4","P5"));
        assertEquals(l1,orgFileUser.getFollowers("O2"));
    }

    @Test
    void testCreateAnEvent(){


    }

    @Test
    void testDeleteAnEvent(){

    }

    @Test
    void testCheckIfUsernameExist(){
        assertTrue(orgFileUser.checkIfUsernameExist("O1"));
        assertTrue(orgFileUser.checkIfUsernameExist("O2"));
        assertTrue(orgFileUser.checkIfUsernameExist("O3"));
        assertFalse(orgFileUser.checkIfUsernameExist("Not1"));
        assertFalse(orgFileUser.checkIfUsernameExist("Not2"));
        assertFalse(orgFileUser.checkIfUsernameExist("Not3"));
    }

    @Test
    void testCreateOrg(){}

    @Test
    void testDeleteOrg(){}

    @Test
    void testOrganizerSearch(){
        ArrayList<String> l1 = new ArrayList<>(List.of("O1", "O2","O3"));
        assertEquals(l1,orgFileUser.organizerSearch("O"));

    }


}
