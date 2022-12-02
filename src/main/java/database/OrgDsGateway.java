package database;

import java.util.ArrayList;

public interface OrgDsGateway {
    String getPassword(String username) throws ClassNotFoundException;

    void setPassword(String username, String new_password) throws ClassNotFoundException;

    ArrayList<String> getUnpublishedEvents(String username) throws ClassNotFoundException;

    ArrayList<String> getPastEvents(String username) throws ClassNotFoundException;

    ArrayList<String> getUpcomingEvents(String username) throws ClassNotFoundException;

    ArrayList<String> getFollowers(String username) throws ClassNotFoundException;

    void createAnEvent(String org_username, String title, int status, String description, String location, int year, int month, int day, int hour, int minute) throws ClassNotFoundException;

    void deleteAnEvent(String title) throws ClassNotFoundException;

    boolean checkIfUsernameExist(String username) throws ClassNotFoundException;

    void createOrg(String username, String password) throws ClassNotFoundException;

    ArrayList<String> organizationSearch(String about_name) throws ClassNotFoundException;

    void editAnEvent(String title, String description, String location, int year, int month, int day, int hour, int minute) throws ClassNotFoundException;


}