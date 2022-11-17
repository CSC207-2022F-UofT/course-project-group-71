package database;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import database.EventFileUser;

import static org.junit.jupiter.api.Assertions.*;

public class EventFileUserTest {
    //NOT COMPLETE
    EventFileUser eventFileUser = new EventFileUser();
    @Test
    void getStatusTest(){
        assertEquals(1, eventFileUser.getStatus("CSC207"));
    }
    @Test
    void getTypeTest(){
        assertEquals(0, eventFileUser.getType("CSC207"));
    }
    @Test
    void getDescriptionTest(){
        assertEquals("Many many group work", eventFileUser.getDescription("CSC207"));
    }
    @Test
    void getLocationTest(){
        assertEquals("Bahal", eventFileUser.getLocation("CSC207"));
    }
    @Test
    void getImagePathTest(String title){

    }
    @Test
    void getTimeTest(String title){

    }
    @Test
    void checkIfEventNameExistTest(String eventname){

    }
    @Test
    void deleteEventTest(String event_title){

    }
    @Test
   void getParticipantsTest(String title){

    }
    @Test
    void getOrganizationTest(String title){

    }

    @Test
    void UnpublishedToUpcomingTest(String title){

    }
}
