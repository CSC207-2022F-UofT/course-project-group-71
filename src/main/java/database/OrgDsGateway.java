package database;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrgDsGateway {
    String getPassword(String username) throws SQLException, ClassNotFoundException;

    void setPassword(String username, String new_password) throws SQLException, ClassNotFoundException;

    ArrayList<String> getUnpublishedEvents(String username) throws SQLException, ClassNotFoundException;

    ArrayList<String> getPastEvents(String username) throws SQLException, ClassNotFoundException;

    ArrayList<String> getUpcomingEvents(String username) throws SQLException, ClassNotFoundException;

    ArrayList<String> getFollowers(String username) throws SQLException, ClassNotFoundException;

    void createAnEvent(String org_username, String title, int status, String description, String location, int year, int month, int day, int hour, int minute) throws SQLException, ClassNotFoundException;

    void deleteAnEvent(String username, String title) throws SQLException, ClassNotFoundException;

    boolean checkIfUsernameExist(String username) throws SQLException, ClassNotFoundException;

    void createOrg(String username, String password) throws SQLException, ClassNotFoundException;

    void deleteOrg(String username) throws SQLException, ClassNotFoundException;

    ArrayList<String> organizerSearch(String about_name) throws SQLException, ClassNotFoundException;

    void editAnEvent(String title, String description, String location, int year, int month, int day, int hour, int minute) throws SQLException, ClassNotFoundException;


}