package database;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ParDsGateway {
    String getPassword(String username) throws SQLException, ClassNotFoundException;

    ArrayList<String> getNotifications(String username) throws SQLException, ClassNotFoundException;

    ArrayList<String> getUpcomingEvents(String username) throws SQLException, ClassNotFoundException;

    ArrayList<String> getPastEvents(String username) throws SQLException, ClassNotFoundException;

    ArrayList<String> getFollowedOrg(String username) throws SQLException, ClassNotFoundException;

    void setPassword(String username, String new_password) throws SQLException, ClassNotFoundException;

    void addNotification(String username, String new_notification) throws SQLException, ClassNotFoundException;

    void followOrg(String par_username, String org_username) throws SQLException, ClassNotFoundException;

    void unfollowOrg(String par_username, String org_username) throws SQLException, ClassNotFoundException;

    void registerEvent (String par_username, String title) throws SQLException, ClassNotFoundException;

    void leaveEvent(String par_username, String title) throws SQLException, ClassNotFoundException;

    boolean checkIfUsernameExist(String username) throws SQLException, ClassNotFoundException;

    void createPar(String username, String password) throws SQLException, ClassNotFoundException;

    void deletePar(String username) throws SQLException, ClassNotFoundException;

    void clearNotifications(String username) throws SQLException, ClassNotFoundException;
}
