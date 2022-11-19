package database;

import java.sql.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.*;

public class EventFileUser implements EventDsGateway{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EventFileUser n = new EventFileUser();
        System.out.println(n.utilDeleteEvent("E2"));
    }

    /**This is a tool method that is called by other method to create an event.
     * It took parameters to insert a new row in the table called 'eventfile' which is in the database.
     * The time segment is seperated into five parameters because of database compatibility.
     * It should not return anything but make changes on the database.
     *
     * @param title The title of the event
     * @param description The description of the event
     * @param location The location of the event (It could be a zoom link)
     * @param year The time (year) of the event
     * @param month The time (month) of the event
     * @param day The time (day) of the event
     * @param hour The time (hour) of the event
     * @param minute The time (minute) of the event
     */
    public void utilStoreEvent(String title, String description, String location, int year, int month, int day, int hour, int minute) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "insert into eventfile(title,description,location,year,month,day,hour,minute) values('" +
                    title + "','" + description + "','" + location + "'," + year + "," + month + "," + day + "," + hour + "," + minute + ");";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0 ){
                System.out.println("Success");
            }
            else {
                System.out.println("Failure");
            }

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } finally {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }
    }

    /**This is a tool method used to edit the event information
     *
     * @param title The title of the event
     * @param status The status of the event (We are considering deleting it)
     * @param description The description of the event
     * @param location The location of the event (It could be a zoom link)
     * @param year The time (year) of the event
     * @param month The time (month) of the event
     * @param day The time (day) of the event
     * @param hour The time (hour) of the event
     * @param minute The time (minute) of the event
     */

    public void utilEditEvent(String title, String description, String location, int year, int month, int day, int hour, int minute) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql =  "update eventfile set description = '" + description + "', location = '" + location + "', year= " + year + ", month = " + month +", day = " + day + ", hour = " + hour + ", minute = " + minute + " where title = '" + title + "';";

            System.out.println(sql);
            System.out.println(sql);
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0 ){
                System.out.println("Success");
            }
            else {
                System.out.println("Failure");
            }

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } finally {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }
    }

    /**
     * This is a tool method used for deleting an event.
     * This is not the whole function of event deletion, it only deletes event from a table called 'eventfile'.
     * It did not break relationships of the event with other tables.
     * It should not return anything.
     *
     * @param title The title of the event that need to be deleted
     * @return False
     */
    public boolean utilDeleteEvent(String title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "delete from eventfile where title = '" + title + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0 ){
                System.out.println("Success");
            }
            else {
                System.out.println("Failure");
            }

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException( );
        } catch (SQLException e) {
            throw new SQLException( );
        } finally {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }
        return false;
    }

    /**This is a tool method to find the organization who create a specific event.
     * It should return a String as the name of the organization.
     * It should return null if the event does not have an organizer (By project design, it should be impossible).
     *
     * @param title The title of the event that need the name of the organization who created it
     * @return the name of the organization who created the event
     */
    public String utilGetOrganization(String title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet unpublished_organizer = null;
        ResultSet past_organizer = null;
        ResultSet upcoming_organizer = null;
        String organizer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            unpublished_organizer = stmt.executeQuery("select org_username from unpublished_events_for_org where event_title = '" + title + "';");
            if (unpublished_organizer.next()){
                organizer = unpublished_organizer.getString(1);
                unpublished_organizer.close();
            }

            past_organizer = stmt.executeQuery("select org_username from past_events_for_org where event_title = '" + title + "';");
            if (past_organizer.next()){
                organizer = past_organizer.getString(1);
                past_organizer.close();
            }

            upcoming_organizer = stmt.executeQuery("select org_username from upcoming_events_for_org where event_title = '" + title + "';");
            if (upcoming_organizer.next()){
                organizer = upcoming_organizer.getString(1);
                upcoming_organizer.close();
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (unpublished_organizer != null){
                unpublished_organizer.close();
            }
            if (past_organizer != null){
                    past_organizer.close();
            }
            if (upcoming_organizer != null){
                upcoming_organizer.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }
        return organizer;
    }

    /**This is a tool method which can only find participants of a past event.
     * If the event is not a past event, it should return an empty ArrayList.
     *
     * @param title The title of the event(which is a past event) that need the list of all participants
     * @return The list containing all participants of the event
     */
    public ArrayList<String> utilGetAllPastEventParticipant(String title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select par_username from past_events_for_par where event_title = '" + title + "';");
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();

            }
            if (conn != null){
                conn.close();
            }
        }
        return l;


    }

    /**This is a tool method that only returns participants of an upcoming event.
     * If the event is not an upcoming event, it returns an empty ArrayList.
     *
     * @param title The title of the event(which is an upcoming event) that need the list of all participants
     * @return The list containing all participants of the event
     */
    public ArrayList<String> utilGetAllUpcomingEventParticipant(String title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select par_username from upcoming_events_for_par where event_title = '" + title + "';");
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }
        return l;


    }

    /**This is a tool method that is used to change the relationship of organizer with the event.
     * Note it only change the relationship of the organizer not the participant.
     * The event would become an upcoming event instead of an unpublished event for the organizer.
     * The relationship of the event with the participants would not change so far.
     * If the event is not unpublished, it should not do anything and the error would be dealt with an exception.
     *
     * @param title The title of the event that need to change the status
     */
    public void utilUnpublishedToUpcomingForOrg(String title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            String orgName = getOrganization(title);
            System.out.println(orgName);
            System.out.println(title);
            String sql1 = "delete from unpublished_events_for_org where event_title = '" + title + "';";
            int count1 = stmt.executeUpdate(sql1);
            System.out.println(sql1);
            String sql2 = "insert into upcoming_events_for_org(org_username, event_title) values('" + orgName + "','" + title + "');";
            System.out.println(sql2);
            int count2 = stmt.executeUpdate(sql2);
            System.out.println(count2);
            if (count1 > 0 && count2 > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
    }

    /**
     * This is a tool method that is used to change the relationship of organizer with the event.
     * Note it only change the relationship with the organizer not the participant.
     * The event would become a past event instead of an upcoming event for the organizer.
     * The relationship of the event with the participants would not change so far.
     * If the event is not upcoming, it should not do anything and the error would be dealt with an exception.
     *
     * @param title The title of the event that need to change the status
     */
    private void utilUpcomingToPastForOrg(String title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            String orgName = getOrganization(title);
            String sql1 = "delete from upcoming_events_for_org where event_title = '" + title + "';";
            int count1 = stmt.executeUpdate(sql1);
            String sql2 = "insert into past_events_for_org(org_username, event_title) values('" + orgName + "','" + title + "');";
            int count2 = stmt.executeUpdate(sql2);
            System.out.println(count2);
            if (count1 > 0 && count2 > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
    }

    /**This is a tool method used to change the relationship of the participants with the event.
     * Note it only change the relationship with the participants not the organizer.
     * The status of the event for the participants would be changed from upcoming to past.
     * If the event is not an upcoming event, it would meet an error which would be dealt with exception.
     *
     * @param title The title of the event that need to change the status
     */
    private void utilUpcomingToPastForPar(String title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            ArrayList<String> ParticipantList = getParticipants(title);
            System.out.println(title);
            for (String participant : ParticipantList){
                stmt.executeUpdate("delete from upcoming_events_for_par where event_title = '" + title + "';");
                stmt.executeUpdate("insert into past_events_for_par(par_username, event_title) values('" + participant + "','" + title + "');");
            }
            System.out.println("Success");
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
    }

    /**This is a tool method used for searching event.
     * It should return an arraylist containing all relevant event titles.
     * If there's no event that have title relevant to the entered keyword, it should return an empty arraylist.
     *
     * @param about_name The keyword entered by user to search relevant event name
     * @return An arraylist containing all relevant event names
     */
    public ArrayList<String> utilEventSearch(String about_name) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select title from eventfile where title like \"%" + about_name + "%\";");
            while (rs.next()) {
                l.add(rs.getString("title"));
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return l;
    }

    /**This is a tool method that examine which status is the event.
     * It will examine all three tables of the organizer-event relationship.
     * Check which one contain the relationship.
     * If it's contained in two tables, it will return the last one's relationship (It should not happen if the project works correctly).
     *
     * @param title The title of the event that need to know the status
     * @return The status of the input event
     */
    public String utilGetStatus(String title) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        String status = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            String sql1 = "select * from unpublished_events_for_org where event_title = '" + title + "';";
            String sql2 = "select * from past_events_for_org where event_title = '" + title + "';";
            String sql3 = "select * from upcoming_events_for_org where event_title = '" + title + "';";
            System.out.println(title);
            System.out.println(sql1);
            System.out.println(sql2);
            System.out.println(sql3);
            rs1 = stmt.executeQuery(sql1);
            if (rs1.next()){
                status = "Unpublished";
                System.out.println("Pass1");
            }
            rs2 = stmt.executeQuery(sql2);
            if (rs2.next()){
                status = "Past";
                System.out.println("Pass2");
            }
            rs3 = stmt.executeQuery(sql3);
            if (rs3.next()){
                status = "Upcoming";
                System.out.println("Pass3");
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        }finally {
            if(rs1 != null){
                rs1.close();
            }
            if(rs2 != null){
                rs2.close();
            }
            if(rs3 != null){
                rs3.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return status;
    }



    /**A tool method used to get the time of the method.
     * The time is returned as an Arraylist.
     *
     * @param title The title of the event that need the time returned
     * @return The time of the event as [year,month,day,hour,minute]
     */
    public ArrayList<Integer> utilGetTime(String title) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<Integer> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select year,month,day,hour,minute from eventfile where title = '" + title + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            l.add(rs.getInt("year"));
            l.add(rs.getInt("month"));
            l.add(rs.getInt("day"));
            l.add(rs.getInt("hour"));
            l.add(rs.getInt("minute"));
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        }finally {
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return l;
    }

    /**This is a tool method used to get the description of the event.
     *
     * @param title The title of event that need the description returned
     * @return The description of the event
     */
    public String utilGetDescription(String title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String description = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select description from eventfile where title = '" + title + "';";
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                description = rs.getString("description");}
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        }finally {
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return description;
    }

    /**It's a tool method that is used to obtain the location of the event.
     * Potentially return a zoom link.
     *
     * @param title The title of the event that need the location returned
     * @return The location of the event
     */
    public String utilGetLocation(String title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String location = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select location from eventfile where title = '" + title + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            location = rs.getString("location");
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        }finally {
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return location;
    }


    /**A tool method that returned the participant list of the event.
     *
     * @param title The title of the event that need all the participants returned
     * @return An Arraylist containing all the participants
     */
    public ArrayList<String> utilGetParticipants(String title) throws SQLException, ClassNotFoundException {
        ArrayList<String> l1 = utilGetAllPastEventParticipant(title);
        ArrayList<String> l2 = utilGetAllUpcomingEventParticipant(title);
        ArrayList<String> l = new ArrayList<>(0);
        l.addAll(l1);
        l.addAll(l2);
        return l;
    }


    /**This is a tool method returning whether the event exist.
     * If not found, returned false, which is the default value of the boolean stored in the method.
     *
     * @param eventName The event name that need to be used to check existence
     * @return Whether the event exists
     */
    public boolean utilCheckIfEventNameExist(String eventName) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean WhetherExist = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select * from eventfile where title = '" + eventName + "';";
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                WhetherExist = true;
            }

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        }finally {
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return WhetherExist;
    }




    /**This is a method used to get the current status of the event(upcoming, past or unpublished).
     * It calls a tool method calls utilGetStatus.
     *
     * @param title The title of the event that need to know the status
     * @return The status of the input event
     */
    public String getStatus(String title) throws SQLException, ClassNotFoundException {
        return utilGetStatus(title);
    }

    /**This is a method used to get the event description.
     * It calls a tool method called getType.
     *
     * @param title The title of event that need the description returned
     * @return The description of the event
     */
    public String getDescription(String title) throws SQLException, ClassNotFoundException {
        return utilGetDescription(title);
    }

    /**It's a method used to get the event location.
     * Potentially return a zoom link.
     * It calls a tool method called utilGetLocation.
     *
     * @param title The title of the event that need the location returned
     * @return The location of the event
     */
    public String getLocation(String title) throws SQLException, ClassNotFoundException {
        return utilGetLocation(title);
    }

    /**A method that returned the time of the input event.
     * The method called a tool method called utilGetTime.
     * The time is returned as an Arraylist .
     *
     * @param title The title of the event that need the time returned
     * @return The time of the event as [year,month,day,hour,minute]
     */
    public ArrayList<Integer> getTime(String title) throws SQLException, ClassNotFoundException {
        return utilGetTime(title);
    }

    /**A method that returned the participant list of the event.
     * It should call a tool method called utilGetParticipants.
     *
     * @param title The title of the event that need all the participants returned
     * @return An Arraylist containing all the participants
     */
    public ArrayList<String> getParticipants(String title) throws SQLException, ClassNotFoundException {
        return utilGetParticipants(title);
    }

    /**This is a method returning the organizer who create the event.
     * It calls a tool method called utilGetOrganization.
     *
     * @param title The title of the event that need the organizer who create the event returned
     * @return The organizer of the event
     */
    public String getOrganization(String title) throws SQLException, ClassNotFoundException {
        return utilGetOrganization(title);
    }

    /**The method calls a tool method called utilUnpublishedToUpcomingForOrg to change the status of the event.
     * The event currently have no participants so no need to worry about participant relationships.
     * the event must be unpublished and should only have one status
     *
     * @param title The title of the event that's unpublished and need to turn to upcoming
     */
    public void unPublishedToUpcoming(String title) throws SQLException, ClassNotFoundException {
        utilUnpublishedToUpcomingForOrg(title);
    }

    /**The method calls two tool method called utilUpcomingToPastForOrg and utilUpcomingToPastForPar to change the status of the event.
     * The event should only have one state and must be upcoming
     *
     * @param title The title of the event that's upcoming and need to turn to past
     */
    public void upcomingToPast(String title) throws SQLException, ClassNotFoundException {
        utilUpcomingToPastForOrg(title);
        utilUpcomingToPastForPar(title);
    }

    /**This method is used for searching event.
     * This is method called a tool method called utilEventSearch.
     * It should return an arraylist containing all relevant event titles.
     * If there's no event that have title relevant to the entered keyword, it should return an empty arraylist.
     *
     * @param about_name The keyword entered by user to search relevant event name
     * @return An arraylist containing all relevant event names
     */
    public ArrayList<String> eventSearch(String about_name) throws SQLException, ClassNotFoundException {
        return utilEventSearch(about_name);
    }

    /**This is a method returning whether the event exist.
     * It calls a method called utilCheckIfEventNameExist.
     * If not found, returned false, which is the default value of boolean stored in the method.
     *
     * @param eventName The event name that need to be used to check existence
     * @return Whether the event exists
     */
    public boolean checkIfEventNameExist(String eventName) throws SQLException, ClassNotFoundException {
        return utilCheckIfEventNameExist(eventName);
    }

    /**This is a method that delete that event and all the relationships with it
     * including participants and organizers.
     * It calls utilDeleteParPastEvent, utilDeleteParUpcomingEvent, utilDeleteOrgPastEvent, utilDeleteOrgUnpublishedEvent, utilDeleteOrgUpcomingEvent
     * to break all the potential relationships.
     * And it calls utilGetOrganization to get the organizer name.
     * The existence of the event should be wiped out of the database.
     *
     * @param event_title The title of the event that need to be deleted
     */

    public void deleteEvent(String event_title) throws SQLException, ClassNotFoundException {
        OrgFileUser temp_orgFileUser = new OrgFileUser();
        ParFileUser temp_parFileUser = new ParFileUser();
        ArrayList<String> All_past_participants = utilGetAllPastEventParticipant(event_title);
        for (String all_past_participant : All_past_participants) {
            temp_parFileUser.utilDeleteParPastEvent(all_past_participant, event_title);
        }
        ArrayList<String> All_upcoming_participants = utilGetAllUpcomingEventParticipant(event_title);
        for (String all_upcoming_participant : All_upcoming_participants) {
            temp_parFileUser.utilDeleteParUpcomingEvent(all_upcoming_participant, event_title);
        }


        String organizer = utilGetOrganization(event_title);
        temp_orgFileUser.utilDeleteOrgPastEvent(organizer,event_title);
        temp_orgFileUser.utilDeleteOrgUnpublishedEvent(organizer,event_title);
        temp_orgFileUser.utilDeleteOrgUpcomingevent(organizer,event_title);

        utilDeleteEvent(event_title);

    }

    public void editEvent(String title, String description, String location, int year, int month, int day, int hour, int minute) throws SQLException, ClassNotFoundException {
        utilEditEvent(title,description,location,year,month,day,hour,minute);
    }

}
