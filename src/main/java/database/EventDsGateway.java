package database;

import java.util.ArrayList;

public interface EventDsGateway {

    public String getStatus(String title);

    public String getDescription(String title);

    public String getLocation(String title);

    public ArrayList<Integer> getTime(String title);

    public ArrayList<String> getParticipants(String title);

    public String getOrganization(String title);

    public void unPublishedToUpcoming(String title);

    public void upcomingToPast(String title);

    public ArrayList<String> eventSearch(String about_name);

    public boolean checkIfEventNameExist(String eventName);

    public void deleteEvent(String event_title);

    public void editEvent(String title, int status, String description, String location, int year, int month, int day, int hour, int minute);
}
