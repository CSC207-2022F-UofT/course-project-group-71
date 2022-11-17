package database;

import java.util.ArrayList;

public interface EventDsGateway {

    public String getStatus(String title);

    public String getDescription(String title);

    public String getLocation(String title);

    public ArrayList<Integer> getTime(String title);

    public ArrayList<String> getParticipants(String title);

    public String getOrganization(String title);

    public void UnpublishedToUpcoming(String title);

    public void UpcomingToPast(String title);

    public ArrayList<String> eventSearch(String about_name);

    public boolean checkIfEventNameExist(String eventName);

    public void deleteEvent(String event_title);
}
