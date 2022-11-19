package database;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EventDsGateway {

    String getStatus(String title) throws SQLException, ClassNotFoundException;

    String getDescription(String title) throws SQLException, ClassNotFoundException;

    String getLocation(String title) throws SQLException, ClassNotFoundException;

    ArrayList<Integer> getTime(String title) throws SQLException, ClassNotFoundException;

    ArrayList<String> getParticipants(String title) throws SQLException, ClassNotFoundException;

    String getOrganization(String title) throws SQLException, ClassNotFoundException;

    void unPublishedToUpcoming(String title) throws SQLException, ClassNotFoundException;

    void upcomingToPast(String title) throws SQLException, ClassNotFoundException;

    ArrayList<String> eventSearch(String about_name) throws SQLException, ClassNotFoundException;

    boolean checkIfEventNameExist(String eventName) throws SQLException, ClassNotFoundException;

    void deleteEvent(String event_title) throws SQLException, ClassNotFoundException;

    void editEvent(String title, String description, String location, int year, int month, int day, int hour, int minute) throws SQLException, ClassNotFoundException;
}
