package database;

import java.util.ArrayList;

public interface EventDsGateway {

    String getStatus(String title) throws ClassNotFoundException;

    String getDescription(String title) throws ClassNotFoundException;

    String getLocation(String title) throws ClassNotFoundException;

    ArrayList<Integer> getTime(String title) throws ClassNotFoundException;

    ArrayList<String> getParticipants(String title) throws ClassNotFoundException;

    String getOrganization(String title) throws ClassNotFoundException;

    void unPublishedToUpcoming(String title) throws ClassNotFoundException;

    void upcomingToPast(String title) throws ClassNotFoundException;

    ArrayList<String> eventSearch(String about_name) throws ClassNotFoundException;

    boolean checkIfEventNameExist(String eventName) throws ClassNotFoundException;

    void deleteEvent(String event_title) throws ClassNotFoundException;

    void editEvent(String title, String description, String location, int year, int month, int day, int hour, int minute) throws ClassNotFoundException;
}
