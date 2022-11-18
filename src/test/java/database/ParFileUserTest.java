package database;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ParFileUserTest {
    
    ParFileUser parFileUser = new ParFileUser();
    
    @Test
    void testGetPassword(){
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
    void testGetNotifications(){
        ArrayList<String> l1 = new ArrayList<>(List.of("Note1 for P1","Note2 for P1","Note3 for P1","Note4 for P1"));
        assertEquals(l1,parFileUser.getNotifications("P1"));
    }

    @Test
    void testGetUpcomingEvents(){
        ArrayList<String> l1 = new ArrayList<>(List.of("E4"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P1"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P2"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P3"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P4"));
        assertEquals(l1,parFileUser.getUpcomingEvents("P5"));
    }

    @Test
    void testGetPastEvents(){
        ArrayList<String> l1 = new ArrayList<>(List.of("E5"));
        assertEquals(l1,parFileUser.getPastEvents("P6"));
        assertEquals(l1,parFileUser.getPastEvents("P7"));
        assertEquals(l1,parFileUser.getPastEvents("P8"));
        assertEquals(l1,parFileUser.getPastEvents("P9"));
        assertEquals(l1,parFileUser.getPastEvents("P10"));
    }

    @Test
    void testGetFollowedOrg(){
        ArrayList<String> l1 = new ArrayList<>(List.of("O2"));
        assertEquals(l1,parFileUser.getFollowedOrg("P1"));
        assertEquals(l1,parFileUser.getFollowedOrg("P2"));
        assertEquals(l1,parFileUser.getFollowedOrg("P3"));
        assertEquals(l1,parFileUser.getFollowedOrg("P4"));
        assertEquals(l1,parFileUser.getFollowedOrg("P5"));


    }

    @Test
    void testSetPassword(){

    }

    @Test
    void testAddNotification(){

    }

    @Test
    void testFollowOrg(){}



    @Test
    void testRegisterEvent(){

    }

    @Test
    void testLeaveEvent(){

    }

    @Test
    void testCheckIfUsernameExist(){
        assertTrue(parFileUser.checkIfUsernameExist("P1"));
        assertTrue(parFileUser.checkIfUsernameExist("P2"));
        assertTrue(parFileUser.checkIfUsernameExist("P3"));
        assertTrue(parFileUser.checkIfUsernameExist("P4"));
        assertFalse(parFileUser.checkIfUsernameExist("P-1"));
    }

    @Test
    void testCreatePar(){

    }

    @Test
    void testDeletePar(String usename){

    }

    @Test
    void testclearNotifications(String usename){

    }
}
