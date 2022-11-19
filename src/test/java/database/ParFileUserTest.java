package database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ParFileUserTest {
    
    ParFileUser parFileUser = new ParFileUser();
    
    @Test
    void testGetPassword() throws SQLException, ClassNotFoundException {
        assertEquals("p1", parFileUser.getPassword("P1"));
        assertEquals("p2", parFileUser.getPassword("P2"));
        assertEquals("p3", parFileUser.getPassword("P3"));
        assertEquals("p4", parFileUser.getPassword("P4"));
        assertEquals("p5", parFileUser.getPassword("P5"));
        assertNotEquals("s1", parFileUser.getPassword("P1"));
        assertNotEquals("s2", parFileUser.getPassword("P2"));
        assertNotEquals("s3", parFileUser.getPassword("P3"));
        assertNotEquals("s4", parFileUser.getPassword("P4"));
        assertNotEquals("s5", parFileUser.getPassword("P5"));
    }

    @Test
    void testGetNotifications() throws SQLException, ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("Note1 for P1","Note2 for P1","Note3 for P1","Note4 for P1"));
        assertEquals(l1,parFileUser.getNotifications("P1"));
    }

    @Test
    void testGetUpcomingEvents() throws SQLException, ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("E4"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P1"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P2"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P3"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P4"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P5"));
    }

    @Test
    void testGetPastEvents() throws SQLException, ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("E5"));
        assertEquals(l1,parFileUser.getPastEvents("P6"));
        assertEquals(l1,parFileUser.getPastEvents("P7"));
        assertEquals(l1,parFileUser.getPastEvents("P8"));
        assertEquals(l1,parFileUser.getPastEvents("P9"));
        assertEquals(l1,parFileUser.getPastEvents("P10"));
    }

    @Test
    void testGetFollowedOrg() throws SQLException, ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("O2"));
        assertEquals(l1,parFileUser.getFollowedOrg("P1"));
        assertEquals(l1,parFileUser.getFollowedOrg("P2"));
        assertEquals(l1,parFileUser.getFollowedOrg("P3"));
        assertEquals(l1,parFileUser.getFollowedOrg("P4"));
        assertEquals(l1,parFileUser.getFollowedOrg("P5"));


    }

    @Test
    void testSetPassword() throws SQLException, ClassNotFoundException {
        assertEquals("p1", parFileUser.getPassword("P1"));
        parFileUser.setPassword("P1", "temp_password");
        assertEquals("temp_password", parFileUser.getPassword("P1"));

        parFileUser.setPassword("P1", "O1password");
        assertEquals("O1password", parFileUser.getPassword("P1"));
    }

    @Test
    void testAddNotification() throws SQLException, ClassNotFoundException {
        ArrayList<String> Notifications = parFileUser.getNotifications("P2");
        assertFalse(Notifications.contains("Note_Temp"));
        parFileUser.addNotification("P2", "Note_Temp");

        parFileUser.clearNotifications("P2");
    }

    @Test
    void testFollowOrg() throws SQLException, ClassNotFoundException {
        ArrayList<String> FollowedOrg = parFileUser.getFollowedOrg("P1");
        assertFalse(FollowedOrg.contains("O3"));

        parFileUser.followOrg("P1","O3");
        FollowedOrg = parFileUser.getFollowedOrg("P1");

        assertTrue(FollowedOrg.contains("O3"));

        parFileUser.unfollowOrg("P1", "O3");
    }



    @Test
    void testRegisterEvent() throws SQLException, ClassNotFoundException {
        parFileUser.registerEvent("P3","E3");
        assertTrue(parFileUser.getUpcomingEvents("P3").contains("E3"));
        parFileUser.leaveEvent("P3", "E3");


    }

    @Test
    void testLeaveEvent() throws SQLException, ClassNotFoundException {
        parFileUser.registerEvent("P3","E3");
        assertTrue(parFileUser.getUpcomingEvents("P3").contains("E3"));
        parFileUser.leaveEvent("P3", "E3");
        assertFalse(parFileUser.getUpcomingEvents("P3").contains("E3"));

    }

    @Test
    void testCheckIfUsernameExist() throws SQLException, ClassNotFoundException {
        assertTrue(parFileUser.checkIfUsernameExist("P1"));
        assertTrue(parFileUser.checkIfUsernameExist("P2"));
        assertTrue(parFileUser.checkIfUsernameExist("P3"));
        assertTrue(parFileUser.checkIfUsernameExist("P4"));
        assertFalse(parFileUser.checkIfUsernameExist("P-1"));
    }

    @Test
    void testCreatePar() throws SQLException, ClassNotFoundException {
        assertFalse(parFileUser.checkIfUsernameExist("P11"));
        parFileUser.createPar("P11", "temp_password");
        parFileUser.checkIfUsernameExist("P11");
        parFileUser.deletePar("P11");
    }

    @Test
    void testDeletePar() throws SQLException, ClassNotFoundException {
        assertFalse(parFileUser.checkIfUsernameExist("P11"));
        parFileUser.createPar("P11", "temp_password");
        assertTrue(parFileUser.checkIfUsernameExist("P11"));
        parFileUser.deletePar("P11");
        assertFalse(parFileUser.checkIfUsernameExist("P11"));
    }

    @Test
    void testclearNotifications(String usename) throws SQLException, ClassNotFoundException {
        ArrayList<String> Notifications = parFileUser.getNotifications("P2");
        assertTrue(Notifications.isEmpty());
        parFileUser.addNotification("P2", "Note_Temp");
        assertFalse(Notifications.isEmpty());
        parFileUser.clearNotifications("P2");
        assertTrue(Notifications.isEmpty());

    }
}
