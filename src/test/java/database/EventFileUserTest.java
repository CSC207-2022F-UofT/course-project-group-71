package database;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventFileUserTest {
    //NOT COMPLETE
    EventFileUser eventFileUser = new EventFileUser();
    @Test
    void testGetStatus(){
        assertEquals("Unpublished", eventFileUser.getStatus("E1"));
        assertEquals("Upcoming", eventFileUser.getStatus("E2"));
        assertEquals("Past", eventFileUser.getStatus("E3"));
    }

    @Test
    void testGetDescription(){
        assertEquals("Testing unpublished", eventFileUser.getDescription("E1"));
        assertEquals("Testing upcoming", eventFileUser.getDescription("E2"));
        assertEquals("Testing past", eventFileUser.getDescription("E3"));
    }

    @Test
    void testGetLocation(){
        assertEquals("zoom1", eventFileUser.getLocation("E1"));
        assertEquals("zoom2", eventFileUser.getLocation("E2"));
        assertEquals("zoom3", eventFileUser.getLocation("E3"));
    }

    @Test
    void testGetTime(){
        ArrayList<Integer> l1 = new ArrayList<>(
                List.of(2024,1,1,1,1));
        ArrayList<Integer> l2 = new ArrayList<>(
                List.of(2026,2,2,2,2));
        ArrayList<Integer> l3 = new ArrayList<>(
                List.of(2000,3,3,3,3));
        assertEquals(l1, eventFileUser.getTime("E1"));
        assertEquals(l2, eventFileUser.getTime("E2"));
        assertEquals(l3, eventFileUser.getTime("E3"));
    }

    @Test
    void testGetParticipants(){
        ArrayList<String> l1 = new ArrayList<>(List.of("P1","P2","P3","P4","P5"));
        assertEquals(l1,eventFileUser.getParticipants("E4"));
    }

    @Test
    void testGetOrganization(){
        assertEquals("O1", eventFileUser.getOrganization("E1"));
        assertEquals("O1", eventFileUser.getOrganization("E2"));
        assertEquals("O1", eventFileUser.getOrganization("E3"));
        assertEquals("O1", eventFileUser.getOrganization("E4"));

    }

    @Test
    void testUnpublishedToUpcoming(){
        //First test whether unpublished contain
    }

    @Test
    void testUpcomingToPast(){}

    @Test
    void testEventSearch(){
        ArrayList<String> l1 = new ArrayList<>(List.of("E1","E2","E3","E4"));
        assertEquals(l1,eventFileUser.eventSearch("E"));
    }

    @Test
    void testCheckIfEventNameExist(){
        assertTrue(eventFileUser.checkIfEventNameExist("E1"));
        assertTrue(eventFileUser.checkIfEventNameExist("E2"));
        assertTrue(eventFileUser.checkIfEventNameExist("E3"));
        assertTrue(eventFileUser.checkIfEventNameExist("E4"));
        assertFalse(eventFileUser.checkIfEventNameExist("E-1"));
    }

    @Test
    void testDeleteEvent(){}

    void testEditEvent(){}









}
