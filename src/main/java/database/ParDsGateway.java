package database;

import java.util.ArrayList;

public interface ParDsGateway {
    public String getPassword(String username);

    public String getNotification(String username);

    public ArrayList<String> getUpcomingEvents(String username);

    public ArrayList<String> getPastEvents(String username);

    public ArrayList<String> getFollowedOrg(String username);

    public void setPassword(String username, String new_password);

    public void setNotification(String username, String new_notification);

    public void followOrg(String par_username, String org_username);

    public void registerEvent(String par_username, String title);

    public void leaveEvent(String par_username, String title);

    public boolean checkIfUsernameExist(String username);

    public void createPar(String username, String password);

    public void deletePar(String username);
}
