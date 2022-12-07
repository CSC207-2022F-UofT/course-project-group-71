package database;

import java.util.ArrayList;

public interface ParDsGateway {
    String getPassword(String username) throws ClassNotFoundException;

    ArrayList<String> getNotifications(String username) throws ClassNotFoundException;

    ArrayList<String> getUpcomingEvents(String username) throws ClassNotFoundException;

    ArrayList<String> getPastEvents(String username) throws ClassNotFoundException;

    ArrayList<String> getFollowedOrg(String username) throws ClassNotFoundException;

    void setPassword(String username, String new_password) throws ClassNotFoundException;

    void addNotification(String username, String new_notification) throws ClassNotFoundException;

    void followOrg(String par_username, String org_username) throws ClassNotFoundException;

    void unfollowOrg(String par_username, String org_username) throws ClassNotFoundException;

    void registerEvent (String par_username, String title) throws ClassNotFoundException;

    void leaveEvent(String par_username, String title) throws ClassNotFoundException;

    boolean checkIfUsernameExist(String username) throws ClassNotFoundException;

    void createPar(String username, String password) throws ClassNotFoundException;

    void clearNotifications(String username) throws ClassNotFoundException;
}
