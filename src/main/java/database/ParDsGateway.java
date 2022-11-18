package database;

import java.util.ArrayList;

public interface ParDsGateway {
    String getPassword(String username);

    ArrayList<String> getNotifications(String username);

    ArrayList<String> getUpcomingEvents(String username);

    ArrayList<String> getPastEvents(String username);

    ArrayList<String> getFollowedOrg(String username);

    void setPassword(String username, String new_password);

    boolean addNotification(String username, String new_notification);

    void followOrg(String par_username, String org_username);

    void unfollowOrg(String par_username, String org_username)

    void registerEvent (String par_username, String title);

    void leaveEvent(String par_username, String title);

    boolean checkIfUsernameExist(String username);

    void createPar(String username, String password);

    void deletePar(String username);

    void clearNotifications(String username);
}
