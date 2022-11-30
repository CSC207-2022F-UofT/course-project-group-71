package database;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventFileUserTest {
    //NOT COMPLETE
    final EventDsGateway eventFileUser = new EventFileUser();
    final OrgDsGateway orgFileUser = new OrgFileUser();
    @Test
    void testGetStatus() throws ClassNotFoundException {
        assertEquals("Unpublished", eventFileUser.getStatus("E1"));
        assertEquals("Upcoming", eventFileUser.getStatus("E2"));
        assertEquals("Past", eventFileUser.getStatus("E3"));
    }

    @Test
    void testGetDescription() throws ClassNotFoundException {
        assertEquals("Testing unpublished", eventFileUser.getDescription("E1"));
        assertEquals("Testing upcoming", eventFileUser.getDescription("E2"));
        assertEquals("Testing past", eventFileUser.getDescription("E3"));
    }

    @Test
    void testGetLocation() throws ClassNotFoundException {
        assertEquals("zoom1", eventFileUser.getLocation("E1"));
        assertEquals("zoom2", eventFileUser.getLocation("E2"));
        assertEquals("zoom3", eventFileUser.getLocation("E3"));
    }

    @Test
    void testGetTime() throws ClassNotFoundException {
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
    void testGetParticipants() throws ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("P1","P2","P3","P4","P5","P6"));
        assertEquals(l1,eventFileUser.getParticipants("E4"));
    }

    @Test
    void testGetOrganization() throws ClassNotFoundException {
        assertEquals("O1", eventFileUser.getOrganization("E1"));
        assertEquals("O1", eventFileUser.getOrganization("E2"));
        assertEquals("O1", eventFileUser.getOrganization("E3"));
        assertEquals("O1", eventFileUser.getOrganization("E4"));

    }

    @Test
    void testUnpublishedToUpcoming() throws ClassNotFoundException {
        orgFileUser.createAnEvent("O3", "Test_Unpublished",0,"Test_unpublished", "Testing zoom", 2000,1,1,1,1);
        assertEquals("Unpublished", eventFileUser.getStatus("Test_Unpublished"));
        eventFileUser.unPublishedToUpcoming("Test_Unpublished");
        assertEquals("Upcoming", eventFileUser.getStatus("Test_Unpublished"));
        orgFileUser.deleteAnEvent("Test_Unpublished");
    }

    @Test
    void testUpcomingToPast() throws ClassNotFoundException {
        //First test whether unpublished contain
        orgFileUser.createAnEvent("O3", "Testing_Upcoming",1,"Testing_Upcoming", "Testing zoom", 2000,1,1,1,1);
        assertEquals("Upcoming", eventFileUser.getStatus("Testing_Upcoming"));
        eventFileUser.upcomingToPast("Testing_Upcoming");
        assertEquals("Past", eventFileUser.getStatus("Testing_Upcoming"));
        orgFileUser.deleteAnEvent("Testing_Upcoming");
    }

    @Test
    void testEventSearch() throws ClassNotFoundException {
        ArrayList<String> l1 = new ArrayList<>(List.of("E1","E2","E3","E4","E5","E6"));
        assertEquals(l1,eventFileUser.eventSearch("E"));
    }

    @Test
    void testCheckIfEventNameExist() throws ClassNotFoundException {
        assertTrue(eventFileUser.checkIfEventNameExist("E1"));
        assertTrue(eventFileUser.checkIfEventNameExist("E2"));
        assertTrue(eventFileUser.checkIfEventNameExist("E3"));
        assertTrue(eventFileUser.checkIfEventNameExist("E4"));
        assertFalse(eventFileUser.checkIfEventNameExist("E-1"));
    }

    @Test
    void testDeleteEvent() throws ClassNotFoundException {
        //Assume the checkIfEventNameExist is False
        assertFalse(eventFileUser.checkIfEventNameExist("DeletionTestingTitle"));
        //Assume createAnEvent is True
        orgFileUser.createAnEvent("O1", "DeletionTestingTitle", 0, "Deletion Testing", "Zoom Testing Deletion", 2000, 1, 1, 1, 1);
        //Assume the checkIfEventNameExist is True
        assertTrue(eventFileUser.checkIfEventNameExist("DeletionTestingTitle"));
        eventFileUser.deleteEvent("DeletionTestingTitle");
        assertFalse(eventFileUser.checkIfEventNameExist("DeletionTestingTitle"));




    }

    @Test
    void testEditEvent() throws ClassNotFoundException {
        //Assume create an event is correct
        orgFileUser.createAnEvent("O1", "DeletionTestingTitle", 0, "Deletion Testing", "Zoom Testing Deletion", 2000, 1, 1, 1, 1);
        orgFileUser.editAnEvent("DeletionTestingTitle", "Editing Testing", "Zoom Testing Editing",2001,2,2,2,2);
        assertEquals("Editing Testing", eventFileUser.getDescription("DeletionTestingTitle"));
        assertEquals("Zoom Testing Editing", eventFileUser.getLocation("DeletionTestingTitle"));
        ArrayList<Integer> l1 = new ArrayList<>(List.of(2001,2,2,2,2));
        assertEquals(l1, eventFileUser.getTime("DeletionTestingTitle"));
        orgFileUser.deleteAnEvent("DeletionTestingTitle");
    }









}
