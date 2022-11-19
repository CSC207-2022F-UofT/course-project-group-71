package database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrgFileUserTest {

    OrgFileUser orgFileUser = new OrgFileUser();

    @Test
    void testGetPassword() throws SQLException, ClassNotFoundException {
        assertEquals("O1password",orgFileUser.getPassword("O1"));
        assertEquals("O2password",orgFileUser.getPassword("O2"));
        assertEquals("O3password",orgFileUser.getPassword("O3"));
    }

    @Test
    void testSetPassword(){

    }

    @Test
    void testGetUnpublishedEvents() throws SQLException, ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("E1"));
        assertEquals(l1,orgFileUser.getUnpublishedEvents("O1"));
    }

    @Test
    void testGetPastEvents() throws SQLException, ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("E3"));
        assertEquals(l1,orgFileUser.getPastEvents("O1"));
    }

    @Test
    void testGetUpcomingEvents() throws SQLException, ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("E2", "E4"));
        assertEquals(l1,orgFileUser.getUpcomingEvents("O1"));
    }

    @Test
    void testGetFollowers() throws SQLException, ClassNotFoundException {
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
    void testCheckIfUsernameExist() throws SQLException, ClassNotFoundException {
        assertTrue(orgFileUser.checkIfUsernameExist("O1"));
        assertTrue(orgFileUser.checkIfUsernameExist("O2"));
        assertTrue(orgFileUser.checkIfUsernameExist("O3"));
        assertFalse(orgFileUser.checkIfUsernameExist("Not1"));
        assertFalse(orgFileUser.checkIfUsernameExist("Not2"));
        assertFalse(orgFileUser.checkIfUsernameExist("Not3"));
    }

    @Test
    void testCreateOrg() throws SQLException, ClassNotFoundException {
        assertFalse(orgFileUser.checkIfUsernameExist("O4"));
        orgFileUser.createOrg("O4", "O4password");
        assertTrue(orgFileUser.checkIfUsernameExist("O4"));
        orgFileUser.deleteOrg("O4");
    }

    @Test
    void testDeleteOrg() throws SQLException, ClassNotFoundException {
        assertTrue(orgFileUser.checkIfUsernameExist("O5"));

    }

    @Test
    void testOrganizerSearch() throws SQLException, ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("O1", "O2","O3"));
        assertEquals(l1,orgFileUser.organizerSearch("O"));

    }


}
