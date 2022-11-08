package database;

import java.util.ArrayList;

public interface OrgDsGateway {
    public ArrayList<String> organizerSearch(String about_name);

    public String getPassword(String username);

    public void setPassword(String username, String new_password);

    public ArrayList<String> getUnpublishedEvents(String username);

    public ArrayList<String> getPastEvent(String username);

    public ArrayList<String> getUpcomingEvents(String username);

    public ArrayList<String> getFollowers(String username);

    //It will create the event and build the connection of the event and the organizer
    public void createAnEvent(String org_username, String title, int status, int event_type, String description, String location, String image_path, int year, int month, int day, int hour, int minute);

    //It will call the event method in EventFileUser which delete all relationships and event itself
    //This might be abundant
    public void deleteAnEvent(String username, String title);

    public boolean checkIfUsernameExist(String username);

    public void createOrg(String username, String password);

    public void deleteOrg(String username);

}
