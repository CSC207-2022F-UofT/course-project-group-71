package database;

import java.sql.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.*;

public class EventFileUser implements EventDsGateway{
    public static void main(String[] args) {
    }

    /**This is a tool method that is called by other method to create an event.
     * It took parameters to insert a new row in the table called 'eventfile' which is in the database.
     * The time segment is seperated into five parameters because of database compatibility.
     * It should not return anything but make changes on the database.
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
    public void utilStoreEvent(String title, int status, String description, String location, int year, int month, int day, int hour, int minute){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "insert into eventfile(title,status,,description,location,year,month,day,hour,minute) values('" +
                    title + "'," + status + ",'" + description + "','" + location + "',," + year + "," + month + "," + day + "," + hour + "," + minute + ");";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0 ){
                System.out.println("Success");
            }
            else {
                System.out.println("Failure");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**This is a tool method used for deleting an event.
     * This is not the whole function of event deletion, it only deletes event from a table called 'eventfile'.
     * It did not break relationships of the event with other tables.
     * It should not return anything.
     *
     * @param title The title of the event that need to be deleted
     */
    public void utilDeleteEvent(String title){
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

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**This is a tool method to find the organization who create a specific event.
     * It should return a String as the name of the organization.
     * It should return null if the event does not have an organizer (By project design, it should be impossible).
     *
     * @param title The title of the event that need the name of the organization who created it
     * @return the name of the organization who created the event
     */
    public String utilGetOrganization(String title){
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (unpublished_organizer != null){
                try {
                    unpublished_organizer.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (past_organizer != null){
                try {
                    past_organizer.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (upcoming_organizer != null){
                try {
                    upcoming_organizer.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
    public ArrayList<String> utilGetAllPastEventParticipant(String title){
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
    public ArrayList<String> utilGetAllUpcomingEventParticipant(String title){
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
    public void utilUnpublishedToUpcomingForOrg(String title){
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

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
    private void utilUpcomingToPastForOrg(String title) {
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

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
    private void utilUpcomingToPastForPar(String title){
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


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
    public ArrayList<String> utilEventSearch(String about_name){
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
            System.out.println("NotFound");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
    public String utilGetStatus(String title){
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
            rs1 = stmt.executeQuery("select exists(select * from unpublished_events_for_org where event_title = '" + title + "');");
            rs2 = stmt.executeQuery("select exists(select * from past_events_for_org where event_title = '" + title + "');");
            rs3 = stmt.executeQuery("select exists(select * from upcoming_events_for_org where event_title = '" + title + "');");
            rs1.next();
            if (rs1.getInt(1) == 1){
                status = "Unpublished";
            }
            rs2.next();
            if (rs2.getInt(1) == 1){
                status = "Past";
            }
            rs2.next();
            if (rs3.getInt(1) == 1){
                status = "Upcoming";
            }
        } catch (ClassNotFoundException e) {
            System.out.println("NotFound");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL");
            e.printStackTrace();
        }finally {
            if(rs1 != null){
                try {
                    rs1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs2 != null){
                try {
                    rs2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs3 != null){
                try {
                    rs3.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }


    /**This is a method used to get the current status of the event(upcoming, past or unpublished).
     * It calls a tool method calls utilGetStatus.
     *
     * @param title The title of the event that need to know the status
     * @return The status of the input event
     */
    public String getStatus(String title){
        return utilGetStatus(title);
    }

    /**This is a tool method used to get the type of the event.
     * The type is currently just integer (considering it to be String).
     *
     * @param title The title of event that need the type returned
     * @return The type of the event
     */
    public int utilGetType(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        int type = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select event_type from eventfile where title = '" + title + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            type = rs.getInt("event_type");
        } catch (ClassNotFoundException e) {
            System.out.println("NotFound");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL");
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return type;
    }

    /**This is a method to get the type of the event.
     * It calls a tool method called utilGetType.
     *
     * @param title The title of event that need the type returned
     * @return The type of the event
     */
    public int getType(String title){
        return utilGetType(title);
    }

    /**This is a tool method used to get the description of the event.
     *
     * @param title The title of event that need the description returned
     * @return The description of the event
     */
    public String utilGetDescription(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String description = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select description from eventfile where title = '" + title + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            description = rs.getString("description");
        } catch (ClassNotFoundException e) {
            System.out.println("NotFound");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL");
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return description;
    }

    /**This is a method used to get the event description.
     * It calls a tool method called getType.
     *
     * @param title The title of event that need the description returned
     * @return The description of the event
     */
    public String getDescription(String title){
        return utilGetDescription(title);
    }

    /**It's a tool method that is used to obtain the location of the event.
     * Potentially return a zoom link.
     *
     * @param title The title of the event that need the location returned
     * @return The location of the event
     */
    public String utilGetLocation(String title){
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
            System.out.println("NotFound");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL");
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return location;
    }

    /**It's a method used to get the event location.
     * Potentially return a zoom link.
     * It calls a tool method called utilGetLocation.
     *
     * @param title The title of the event that need the location returned
     * @return The location of the event
     */
    public String getLocation(String title){
        return utilGetLocation(title);
    }

    public String utilGetImagePath(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String image_path = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select image_path from eventfile where title = '" + title + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            image_path = rs.getString("image_path");
        } catch (ClassNotFoundException e) {
            System.out.println("NotFound");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL");
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return image_path;
    }
    public String getImagePath(String title){
        return utilGetImagePath(title);
    }

    /**A tool method used to get the time of the method.
     * The time is returned as an Arraylist.
     *
     * @param title The title of the event that need the time returned
     * @return The time of the event as [year,month,day,hour,minute]
     */
    public ArrayList<Integer> utilGetTime(String title){
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
            System.out.println("NotFound");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL");
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return l;
    }
    /**A method that returned the time of the input event.
     * The method called a tool method called utilGetTime.
     * The time is returned as an Arraylist .
     *
     * @param title The title of the event that need the time returned
     * @return The time of the event as [year,month,day,hour,minute]
     */
    public ArrayList<Integer> getTime(String title){
        return utilGetTime(title);
    }

    /**A tool method that returned the participant list of the event.
     *
     * @param title The title of the event that need all the participants returned
     * @return An Arraylist containing all the participants
     */
    public ArrayList<String> utilGetParticipants(String title){
        ArrayList<String> l1 = utilGetAllPastEventParticipant(title);
        ArrayList<String> l2 = utilGetAllUpcomingEventParticipant(title);
        ArrayList<String> l = new ArrayList<>(0);
        l.addAll(l1);
        l.addAll(l2);
        return l;
    }
    /**A method that returned the participant list of the event.
     * It should call a tool method called utilGetParticipants.
     *
     * @param title The title of the event that need all the participants returned
     * @return An Arraylist containing all the participants
     */
    public ArrayList<String> getParticipants(String title){
        return utilGetParticipants(title);
    }

    /**This is a method returning the organizer who create the event.
     * It calls a tool method called utilGetOrganization.
     *
     * @param title The title of the event that need the organizer who create the event returned
     * @return The organizer of the event
     */
    public String getOrganization(String title){
        return utilGetOrganization(title);
    }

    /**The method calls a tool method called utilUnpublishedToUpcomingForOrg to change the status of the event.
     * The event currently have no participants so no need to worry about participant relationships.
     * the event must be unpublished and should only have one status
     *
     * @param title The title of the event that's unpublished and need to turn to upcoming
     */
    public void UnpublishedToUpcoming(String title){
        utilUnpublishedToUpcomingForOrg(title);
    }

    /**The method calls two tool method called utilUpcomingToPastForOrg and utilUpcomingToPastForPar to change the status of the event.
     * The event should only have one state and must be upcoming
     *
     * @param title The title of the event that's upcoming and need to turn to past
     */
    @Override
    public void UpcomingToPast(String title) {
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
    public ArrayList<String> eventSearch(String about_name){
        return utilEventSearch(about_name);
    }

    /**This is a tool method returning whether the event exist.
     * If not found, returned false, which is the default value of the boolean stored in the method.
     *
     * @param eventName The event name that need to be used to check existence
     * @return Whether the event exists
     */
    public boolean utilCheckIfEventNameExist(String eventName){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean WhetherExist = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", getDatabasePassword());
            String sql = "select exists(select * from eventfile where title = '" + eventName + "');";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            if (rs.getInt(1) == 1){
                WhetherExist = true;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("NotFound");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL");
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return WhetherExist;
    }


    /**This is a method returning whether the event exist.
     * It calls a method called utilCheckIfEventNameExist.
     * If not found, returned false, which is the default value of boolean stored in the method.
     *
     * @param eventName The event name that need to be used to check existence
     * @return Whether the event exists
     */
    public boolean checkIfEventNameExist(String eventName){
        return utilCheckIfEventNameExist(eventName);
    }

    /**This is a method that delete that event and all the relationships with it
     * including participants and organizers.
     * It calls utilDeleteParPastevent, utilDeleteParUpcomingevent, utilDeleteOrgPastEvent, utilDeleteOrgUnpublishedEvent, utilDeleteOrgUpcomingevent
     * to break all the potential relationships.
     * And it calls utilGetOrganization to get the organizer name.
     * The existance of the event should be wiped out of the database.
     *
     * @param event_title The title of the event that need to be deleted
     */

    public void deleteEvent(String event_title){
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
}
