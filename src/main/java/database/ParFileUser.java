package database;

import java.util.ArrayList;

import static database.JDBCUtils.utilQueryArrayListString;
import static database.JDBCUtils.utilUpdateVoid;

public class ParFileUser implements ParDsGateway {
    public static void main(String[] args) throws ClassNotFoundException {
        ParFileUser b = new ParFileUser();
        b.UtilClearNotifications("P2");
        b.addNotification("allyson","cancelled");
    }

    /**This is a tool method used to store the username and password of the participant to the database.
     *
     * @param username The username of the participant
     * @param password The password of the participant\
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void utilStorePar(String username, String password) throws ClassNotFoundException {
        String sql = "insert into parfile(username, password) values('" + username + "','" + password + "');" ;
        utilUpdateVoid(sql);
    }

    /**This is a tool method used to delete the participant from the database.
     *
     * @param username THe username of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void utilDeletePar(String username) throws ClassNotFoundException {
        String sql = "delete from parfile where username = '" + username + "';";
        utilUpdateVoid(sql);
    }

    /**This is a tool method used to add following relationship between participants and organizations to the database.
     *
     * @param par_username The username of the participant
     * @param org_username The username of the organization
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void utilAddParFollowing(String par_username, String org_username) throws ClassNotFoundException {
        String sql = "insert into follow_org_par(par_username, org_username) values('" + par_username + "','" + org_username + "');" ;
        utilUpdateVoid(sql);
    }

    /**This is a tool method used to delete following relationship between participants and organizations from the database.
     * The par must be following the org, otherwise nothing happens.
     *
     * @param par_username The username of the participant
     * @param org_username The username of the organization
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void utilDeleteParFollowOrg(String par_username, String org_username) throws ClassNotFoundException {
        String sql = "delete from follow_org_par where par_username = '" + par_username + "' and org_username = '" + org_username + "';";
        utilUpdateVoid(sql);
    }
// --Commented out by Inspection START (2022-11-29 3:42 p.m.):
//    /**This a tool method used to add relationship between participants and past events to the database.
//     *
//     * @param par_username The username of the participant
//     * @param event_title The title of the event
//     */
//    public void utilAddParPastEvent(String par_username, String event_title) throws SQLException, ClassNotFoundException {
//        String sql = "insert into past_events_for_par(par_username, event_title) values('" + par_username + "','" + event_title + "');" ;
//        utilUpdateVoid(sql);
//    }
// --Commented out by Inspection STOP (2022-11-29 3:42 p.m.)
    /**This a tool method used to delete relationship between participants and past events from the database.
     *The participant must register the past event, otherwise nothing would happen.
     *
     * @param par_username The username of the participant
     * @param event_title The title of the event
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void utilDeleteParPastEvent(String par_username, String event_title) throws ClassNotFoundException {
        String sql = "delete from past_events_for_par where par_username = '" + par_username + "' and event_title = '" + event_title + "';";
        utilUpdateVoid(sql);
    }

    /**This a tool method used to add relationship between participants and upcoming events to the database.
     *
     * @param par_username The username of the participant
     * @param event_title The title of the event
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void utilAddParUpcomingEvent(String par_username, String event_title) throws ClassNotFoundException {
        String sql = "insert into upcoming_events_for_par(par_username, event_title) values('" + par_username + "','" + event_title + "');" ;
        utilUpdateVoid(sql);
    }

    /**This a tool method used to delete relationship between participants and upcoming events from the database.
     * This par must register in the upcoming event, otherwise nothing happens.
     *
     * @param par_username The username of the participant
     * @param event_title The title of the event
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void utilDeleteParUpcomingEvent(String par_username, String event_title) throws ClassNotFoundException {
        String sql = "delete from upcoming_events_for_par where par_username = '" + par_username + "' and event_title = '" + event_title + "';";
        utilUpdateVoid(sql);
    }

    /**This is a tool method used to get all organizations followed by a participant.
     *
     * @param par_username The username of the participant
     * @return All organizations followed by the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ArrayList<String> utilGetAllFollowing(String par_username) throws ClassNotFoundException {
        String sql = "select org_username from follow_org_par where par_username = '" + par_username + "';";
        return utilQueryArrayListString(sql);
    }

    /**This is a tool method used to get all past events registered by a participant.
     *
     * @param par_username The username of the participant
     * @return All past events registered by the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ArrayList<String> utilGetAllPastEvent(String par_username) throws ClassNotFoundException {
        String sql = "select event_title from past_events_for_par where par_username = '" + par_username + "';";
        return utilQueryArrayListString(sql);
    }

    /**This is a tool method used to get all upcoming events registered by a participant.
     *
     * @param par_username The username of the participant
     * @return All upcoming events registered by the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ArrayList<String> utilGetAllUpcomingEvent(String par_username) throws ClassNotFoundException {
        String sql = "select event_title from upcoming_events_for_par where par_username = '" + par_username + "';";
        return utilQueryArrayListString(sql);
    }

    /**This is a tool method used to update the password of a participant.
     *
     * @param par_username The username of the participant
     * @param new_password The new password of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void utilPasswordUpdating(String par_username, String new_password) throws ClassNotFoundException {
        String sql = "update parfile set password = '" + new_password + "' where username = '" + par_username + "';";
        utilUpdateVoid(sql);
    }

    /**This is a tool method used to add new notification to the participant.
     *
     * @param par_username The username of the participant
     * @param new_notification The new notification need to be sent to the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void utilNotificationUpdating(String par_username, String new_notification) throws ClassNotFoundException {
        String sql = "insert ignore into par_notification(par_username, notification) values('" + par_username + "','" + new_notification + "')";
        utilUpdateVoid(sql);
    }

    /**This is a tool method used to get all notifications of the participant.
     *
     * @param par_username The username of the participant
     * @return All notifications of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ArrayList<String> UtilGetNotifications(String par_username) throws ClassNotFoundException {
        String sql = "select notification from par_notification where par_username = '" + par_username + "';";
        return utilQueryArrayListString(sql);
    }

    /**This is a tool method used to delete all notifications of the participant.
     * It no notifications before, nothing change.
     *
     * @param par_username The username of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void UtilClearNotifications(String par_username) throws ClassNotFoundException {
        String sql = "delete from par_notification where par_username = '" + par_username + "';";
        utilUpdateVoid(sql);
    }


    /**This is a tool method used to get the password of the participant.
     *
     * @param username The username of the participant
     * @return The password of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public String utilGetPassword(String username) throws ClassNotFoundException {
        String sql = "select password from parfile where username = '" + username + "';";
        return utilQueryArrayListString(sql).get(0);
    }

    /**This is a tool method returning whether the username exist.
     * If not found, returned false, which is the default value of the boolean stored in method.
     *
     * @param username The username that need to be used to check existence
     * @return Whether the username exists
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public boolean utilCheckIfUsernameExist(String username) throws ClassNotFoundException {
        String sql = "select username from parfile where username = '" + username + "';";
        return !utilQueryArrayListString(sql).isEmpty();
    }


    /**This a method used to add relationship between participants and upcoming events to the database.
     * This method called a tool method called utilAddParUpcomingEvent.
     *
     * @param par_username The username of the participant
     * @param title The title of the event
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void registerEvent(String par_username, String title) throws ClassNotFoundException {
        utilAddParUpcomingEvent(par_username,title);
    }

    /**This a method used to delete relationship between participants and upcoming events from the database.
     * This par must register in the upcoming event, otherwise nothing happens.
     * This method called a tool method called utilDeleteParUpcomingEvent.
     *
     * @param par_username The username of the participant
     * @param title The title of the event
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void leaveEvent(String par_username, String title) throws ClassNotFoundException {
        utilDeleteParUpcomingEvent(par_username,title);
    }

    /**This is a method used to get the password of the participant.
     * This method called a tool method called utilGetPassword.
     *
     * @param username The username of the participant
     * @return The password of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public String getPassword(String username) throws ClassNotFoundException {
        return utilGetPassword(username);
    }

    /**This is a method used to update the password of a participant.
     * This method called a tool method called utilPasswordUpdating.
     *
     * @param username The username of the participant
     * @param new_password The new password of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void setPassword(String username, String new_password) throws ClassNotFoundException {
        utilPasswordUpdating(username, new_password);
    }

    /**This is a method used to get all notifications of the participant.
     * It calls a tool method called UtilGetNotifications.
     *
     * @param par_username The username of the participant
     * @return All notifications of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ArrayList<String> getNotifications(String par_username) throws ClassNotFoundException {
        return UtilGetNotifications(par_username);
    }

    /**This is a method used to get all upcoming events registered by a participant.
     * This method called a tool method called utilGetAllUpcomingEvent.
     *
     * @param username The username of the participant
     * @return All the upcoming events registered by the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ArrayList<String> getUpcomingEvents(String username) throws ClassNotFoundException {
        return utilGetAllUpcomingEvent(username);
    }

    /**This is a method used to get all past events registered by a participant.
     * This method called a tool method called utilGetAllPastEvent.
     *
     * @param username The username of the participant
     * @return All the past events registered by the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ArrayList<String> getPastEvents(String username) throws ClassNotFoundException {
        return utilGetAllPastEvent(username);
    }

    /**This is a method used to get all organizations followed by a participant.
     * This method called a tool method called utilGetAllFollowing.
     *
     * @param username The username of the participant
     * @return All the organizations followed by the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ArrayList<String> getFollowedOrg(String username) throws ClassNotFoundException {
        return utilGetAllFollowing(username);
    }

    /**This is a method used to add following relationship between participants and organizations to the database.
     * This method called a tool method called utilAddParFollowing.
     *
     * @param par_username The username of the participant
     * @param org_username The username of the organization
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void followOrg(String par_username, String org_username) throws ClassNotFoundException {
        utilAddParFollowing(par_username,org_username);
    }

    /**This is a method used to add following relationship between participants and organizations to the database.
     * This method called a tool method called utilAddParFollowing.
     *
     * @param par_username The username of the participant
     * @param org_username The username of the organization
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void unfollowOrg(String par_username, String org_username) throws ClassNotFoundException {
        utilDeleteParFollowOrg(par_username,org_username);
    }


    /**This is a method returning whether the username exist.
     * This method calls a tool method called utilCheckIfUsernameExist.
     * If not found, returned false, which is the default value of the boolean stored in method.
     *
     * @param username The username that need to be used to check existence
     * @return Whether the username exists
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public boolean checkIfUsernameExist(String username) throws ClassNotFoundException {
        return utilCheckIfUsernameExist(username);
    }

    /**This is a method used to store the username and password of the participant to the database.
     * This method called a tool method called utilStorePar.
     *
     * @param username The username of the participant
     * @param password The password of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void createPar(String username, String password) throws ClassNotFoundException {
        utilStorePar(username, password);
    }

    /**This is a method used to delete the participant from the database.
     * The method tooled method including
     * utilGetAllPastEvent, utilGetAllUpcomingEvent, utilGetAllFollowing.
     * It will delete all relationship between the participant and events.
     * And it will remove all following relationships.
     *
     * @param username The username of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void deletePar(String username) throws ClassNotFoundException {
        //First delete relationships with events
        //Then delete relationships with organizations
        //Then delete itself

        //First breaking relationship with past events
        ArrayList<String> All_past_events = utilGetAllPastEvent(username);
        for (String all_past_event : All_past_events) {
            utilDeleteParPastEvent(username, all_past_event);
        }
        ArrayList<String> All_upcoming_events = utilGetAllUpcomingEvent(username);
        for (String all_upcoming_event : All_upcoming_events) {
            utilDeleteParUpcomingEvent(username, all_upcoming_event);
        }

        //Then break relationship with followings
        ArrayList<String> All_following = utilGetAllFollowing(username);
        for (String s : All_following) {
            utilDeleteParFollowOrg(username, s);
        }

        UtilClearNotifications(username);

        utilDeletePar(username);

    }

    /**This is a method used to add notification to a participant.
     * This method called a tool method called utilNotificationUpdating.
     *
     * @param username The username of the participant
     * @param new_notification The new notification sent to the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public void addNotification(String username, String new_notification) throws ClassNotFoundException {
        utilNotificationUpdating(username,new_notification);
    }

    /**This is a method used to delete all notifications of the participant. It no notifications before, nothing change.
     * This method called a tool method called UtilClearNotifications.
     *
     * @param username The username of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    @Override
    public void clearNotifications(String username) throws ClassNotFoundException {
        UtilClearNotifications(username);
    }

// --Commented out by Inspection START (2022-11-29 3:40 p.m.):
//    public Participant getParticipant(String username) throws SQLException, ClassNotFoundException {
//        Participant par_to_return = new Participant(username, getPassword(username), getPastEvents(username), getUpcomingEvents(username), getFollowedOrg(username));
//        return par_to_return;
//    }
// --Commented out by Inspection STOP (2022-11-29 3:40 p.m.)

// --Commented out by Inspection START (2022-11-29 3:40 p.m.):
//    public void SaveParticipant(Participant par_to_save) throws SQLException, ClassNotFoundException {
//        deletePar(par_to_save.getUsername());
//        createPar(par_to_save.getUsername(), par_to_save.getPassword());
//        for (String past_event : par_to_save.getPast_events()) {
//            utilAddParPastEvent(par_to_save.getUsername(), past_event);
//        }
//        for (String upcoming_event : par_to_save.getUpcoming_events()) {
//            utilAddParUpcomingEvent(par_to_save.getUsername(), upcoming_event);
//        }
//        for (String followed_org : par_to_save.getFollowing_list()) {
//            utilAddParFollowing(par_to_save.getUsername(), followed_org);
//        }
//    }
// --Commented out by Inspection STOP (2022-11-29 3:40 p.m.)
}
