package database;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrgFileUserTest {

    final OrgFileUser orgFileUser = new OrgFileUser();
    final EventFileUser eventFileUser = new EventFileUser();

    @Test
    void testGetPassword() throws ClassNotFoundException {
        assertEquals("O1password",orgFileUser.getPassword("O1"));
        assertEquals("O2password",orgFileUser.getPassword("O2"));
        assertEquals("O3password",orgFileUser.getPassword("O3"));
    }

    @Test
    void testSetPassword() throws ClassNotFoundException {
        assertEquals("O1password", orgFileUser.getPassword("O1"));
        orgFileUser.setPassword("O1", "temp_password");
        assertEquals("temp_password", orgFileUser.getPassword("O1"));

        orgFileUser.setPassword("O1", "O1password");
        assertEquals("O1password", orgFileUser.getPassword("O1"));

    }

    @Test
    void testGetUnpublishedEvents() throws ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("E1"));
        assertEquals(l1,orgFileUser.getUnpublishedEvents("O1"));
    }

    @Test
    void testGetPastEvents() throws ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("E3"));
        assertEquals(l1,orgFileUser.getPastEvents("O1"));
    }

    @Test
    void testGetUpcomingEvents() throws ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("E2", "E4"));
        assertEquals(l1,orgFileUser.getUpcomingEvents("O1"));
    }

    @Test
    void testGetFollowers() throws ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("P1","P2","P3","P4","P5"));
        assertEquals(l1,orgFileUser.getFollowers("O2"));
    }

    @Test
    void testCreateAnEvent() throws ClassNotFoundException {
        assertFalse(eventFileUser.checkIfEventNameExist("Testing 3"));
        orgFileUser.createAnEvent("O3", "Testing 3", 0, "E_Temp", "Zoom_Temp", 2000, 0,0,0,0);
        assertTrue(eventFileUser.checkIfEventNameExist("Testing 3"));

        orgFileUser.deleteAnEvent("Testing 3");
    }

    @Test
    void testDeleteAnEvent() throws ClassNotFoundException {
        orgFileUser.createAnEvent("O3", "Testing 4", 0, "E_Temp", "Zoom_Temp", 2000, 0,0,0,0);
        assertTrue(eventFileUser.checkIfEventNameExist("Testing 4"));
        orgFileUser.deleteAnEvent("Testing 4");
        assertFalse(eventFileUser.checkIfEventNameExist("Testing 4"));



    }

    @Test
    void testCheckIfUsernameExist() throws ClassNotFoundException {
        assertTrue(orgFileUser.checkIfUsernameExist("O1"));
        assertTrue(orgFileUser.checkIfUsernameExist("O2"));
        assertTrue(orgFileUser.checkIfUsernameExist("O3"));
        assertFalse(orgFileUser.checkIfUsernameExist("Not1"));
        assertFalse(orgFileUser.checkIfUsernameExist("Not2"));
        assertFalse(orgFileUser.checkIfUsernameExist("Not3"));
    }

    @Test
    void testCreateOrg() throws ClassNotFoundException {
        assertFalse(orgFileUser.checkIfUsernameExist("O4"));
        orgFileUser.createOrg("O4", "O4password");
        assertTrue(orgFileUser.checkIfUsernameExist("O4"));
        orgFileUser.deleteOrg("O4");
    }

    @Test
    void testDeleteOrg() throws ClassNotFoundException {
        assertTrue(orgFileUser.checkIfUsernameExist("O3"));
        orgFileUser.deleteOrg("O3");
        assertFalse(orgFileUser.checkIfUsernameExist("O3"));

        orgFileUser.createOrg("O3", "O3password");



    }

    @Test
    void testOrganizerSearch() throws ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("O1", "O2","O3"));
        assertEquals(l1,orgFileUser.organizationSearch("O"));

    }


}
