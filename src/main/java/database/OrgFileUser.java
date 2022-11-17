package database;

import java.sql.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.*;

public class OrgFileUser implements OrgDsGateway {
    public static void main(String[] args) {
        OrgFileUser a = new OrgFileUser();
        System.out.println(a.organizerSearch("s"));
    }

    /**This is a tool method to store the username and password of the organizer to database.
     *
     * @param username The username of the organizer that need to be stored
     * @param password The password of the organizer that need to be stored
     */
    public void utilStoreOrg(String username, String password){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "insert into orgfile(username, password) values('" + username + "','" + password + "');" ;
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

    /**This is a tool method to delete an organizer from the database.
     * It does not verify whether organizer exists
     * if not exists, then it won't show any thing and won't change anything
     *
     * @param username The username of the organizer that need to be deleted
     */
    public void utilDeleteOrg(String username){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "delete from orgfile where username = '" + username + "';";
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

    /**This is a tool method used to add a relationship from the database.
     * It builds a relationship between an organizer and a past event.
     *
     * @param org_username The username of the organizer
     * @param event_title The title of the event
     */
    public void utilAddOrgPastEvent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "insert into past_events_for_org(org_username, event_title) values('" + org_username + "','" + event_title + "');" ;
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

    /**This is a tool method used to delete a relationship from the database.
     * It deletes a relationship between an organizer and a past event.
     *
     * @param org_username The username of the organizer
     * @param event_title The title of the event
     */
    public void utilDeleteOrgPastEvent(String org_username, String event_title) {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "delete from past_events_for_org where org_username = '" + org_username + "' and event_title = '" + event_title + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0) {
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

    /**This is a tool method used to add a relationship to the database.
     * It adds a relationship between an unpublished event and an organizer.
     *
     * @param org_username The username of the organizer
     * @param event_title The title of the event
     */
    public void utilAddOrgUnpublishedEvent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "insert into unpublished_events_for_org(org_username, event_title) values('" + org_username + "','" + event_title + "');" ;
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

    /**This is a tool method used to delete a relationship from the database.
     * It deletes a relationship between an unpublished event and an organizer.
     *
     * @param org_username The username of the organizer
     * @param event_title The title of the event
     */
    public void utilDeleteOrgUnpublishedEvent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "delete from unpublished_events_for_org where org_username = '" + org_username + "' and event_title = '" + event_title + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0) {
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

    /**This is a tool method used to add a relationship to the database.
     * It adds a relationship between an upcoming event and an organizer.
     *
     * @param org_username The username of the organizer
     * @param event_title The title of the event
     */
    public void utilAddOrgUpcomingEvent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "insert into upcoming_events_for_org(org_username, event_title) values('" + org_username + "','" + event_title + "');" ;
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

    /**This is a tool method used to delete a relationship from the database.
     * It deletes a relationship between an upcoming event and an organizer.
     *
     * @param org_username The username of the organizer
     * @param event_title The title of the event
     */
    public void utilDeleteOrgUpcomingevent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "delete from upcoming_events_for_org where org_username = '" + org_username + "' and event_title = '" + event_title + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0) {
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

    /**This is a tool method used to get all followers' name of the organizer.
     *
     * @param org_username The username of the organizer
     * @return All followers of the organizer
     */
    public ArrayList<String> utilGetAllFollowers(String org_username){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select par_username from follow_org_par where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
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
    /**This is a tool method used to get all unpublished events of the organizer.
     *
     * @param org_username The username of the organizer
     * @return All unpublished events of the organizer
     */
    public ArrayList<String> utilGetUnpublishedEvents(String org_username){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select event_title from unpublished_events_for_org where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
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

    /**This is a tool method used to get all past events of the organizer.
     *
     * @param org_username The username of the organizer
     * @return All past events of the organizer
     */
    public ArrayList<String> utilGetPastEvents(String org_username){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select event_title from past_events_for_org where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
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

    /**This is a tool method used to get all upcoming events of the organizer.
     *
     * @param org_username The username of the organizer
     * @return All upcoming events of the organizer
     */
    public ArrayList<String> utilGetUpcomingEvents(String org_username){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select event_title from upcoming_events_for_org where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
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

    /**This is a tool method used to get the password of the organizer.
     *
     * @param org_username The username of the organizer
     * @return
     */
    public String utilGetPassword(String org_username) {
        //Return the password of the entered organizer user
        //Used for login password check
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String password = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select password from orgfile where username = \"" + org_username + "\";");
            rs.next();
            password = rs.getString("password");
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
        return password;
    }

    /**This is a tool method used to change the password of the organizer
     *
     * @param org_username The username of the organizer
     * @param new_password The new password of the organizer
     */
    public void utilPasswordUpdating(String org_username, String new_password){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "update orgfile set password = '" + new_password + "' where username = '" + org_username + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0) {
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

    /**This is a tool method used to obtain all the organizers relevant to the keyword inputed
     *
     * @param about_name The keyword that used for search for relevant organizer
     * @return An ArrayList containing the name of all relevant organizers
     */
    public ArrayList<String> utilOrganizerSearch(String about_name){
        //This is method is used for searching method of the website
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select username from orgfile where username like \"%" + about_name + "%\";");
            while (rs.next()) {
                l.add(rs.getString("username"));
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














    public ArrayList<String> organizerSearch(String about_name){
        return utilOrganizerSearch(about_name);
    }


    public String getPassword(String username) {
        return utilGetPassword(username);
    }

    public void setPassword(String username, String new_password){
        //
        utilPasswordUpdating(username, new_password);
    }


    public ArrayList<String> getUnpublishedEvents(String username){
        return utilGetUnpublishedEvents(username);
    }

    public ArrayList<String> getPastEvents(String username){
        return utilGetPastEvents(username);
    }

    public ArrayList<String> getUpcomingEvents(String username){
        return utilGetUpcomingEvents(username);
    }

    public ArrayList<String> getFollowers(String username){
        return utilGetAllFollowers(username);
    }

    public void createAnEvent(String org_username,
                              String title,
                              int status,
                              int event_type,
                              String description,
                              String location,
                              String image_path,
                              int year,
                              int month,
                              int day,
                              int hour,
                              int minute){
        EventFileUser temp_eventfileuser = new EventFileUser();
        temp_eventfileuser.utilStoreEvent(title, status, event_type, description, location, image_path, year, month, day, hour, minute);
        if (status == 0){
            //Unpublished
            utilAddOrgUnpublishedEvent(org_username,title);
        }
        else if(status == 1){
            //Past
            utilAddOrgPastEvent(org_username,title);
        }
        else{
            //Upcoming
            utilAddOrgUpcomingEvent(org_username,title);

        }
    }
    public void deleteAnEvent(String username, String title){
        EventFileUser temp_eventfileuser = new EventFileUser();
        temp_eventfileuser.deleteEvent(title);
    }

    public boolean checkIfUsernameExist(String username){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean WhetherExist = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
            String sql = "select exists(select * from orgfile where username = '" + username + "');";
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

    public void createOrg(String username, String password){
        utilStoreOrg(username,password);
    }
    public void deleteOrg(String username){
        //First delete relationships with events
        //Then delete relationships with participants
        //Then delete itself
        ParFileUser temp_parfileuser = new ParFileUser();
        ArrayList<String> All_Unpublished = utilGetUnpublishedEvents(username);
        for (String s : All_Unpublished) {
            utilDeleteOrgUnpublishedEvent(username, s);
        }
        ArrayList<String> All_Past = utilGetPastEvents(username);
        for (String s : All_Past) {
            utilDeleteOrgPastEvent(username, s);
        }
        ArrayList<String> All_upcoming = utilGetUpcomingEvents(username);
        for (int i=0; i<All_Past.size();i++){
            utilDeleteOrgUpcomingevent(username, All_upcoming.get(i));
        }

        ArrayList<String> All_followers = utilGetAllFollowers(username);
        for (String all_follower : All_followers) {
            temp_parfileuser.utilDeleteParFollowOrg(all_follower, username);
        }

        utilDeleteOrg(username);
    }

}
