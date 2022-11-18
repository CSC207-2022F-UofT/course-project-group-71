package database;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrgDsGateway {
    String getPassword(String username);

    void setPassword(String username, String new_password);

    ArrayList<String> getUnpublishedEvents(String username);

    ArrayList<String> getPastEvents(String username);

    ArrayList<String> getUpcomingEvents(String username);

    ArrayList<String> getFollowers(String username);

    void createAnEvent(String org_username, String title, int status, String description, String location, int year, int month, int day, int hour, int minute) throws SQLException;

    void deleteAnEvent(String username, String title);

    boolean checkIfUsernameExist(String username);

    void createOrg(String username, String password);

    void deleteOrg(String username);

    ArrayList<String> organizerSearch(String about_name);

    void editAnEvent(String title, int status, String description, String location, int year, int month, int day, int hour, int minute);


}