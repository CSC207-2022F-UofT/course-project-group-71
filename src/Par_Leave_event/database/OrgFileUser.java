package database;

import database.entity_temp.Organization;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrgFileUser implements OrgDsGateway {


    /**This is a tool method to store the username and password of the organization to database.
     *
     * @param username The username of the organization that need to be stored
     * @param password The password of the organization that need to be stored
     */
    public void utilStoreOrg(String username, String password) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
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

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }

    }

    /**This is a tool method to delete an organization from the database.
     * It does not verify whether organization exists
     * if not exists, then it won't show anything and won't change anything
     *
     * @param username The username of the organization that need to be deleted
     */
    public void utilDeleteOrg(String username) throws SQLException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
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
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }
    }

    /**This is a tool method used to add a relationship from the database.
     * It builds a relationship between an organization and a past event.
     *
     * @param org_username The username of the organization
     * @param event_title The title of the event
     */
    public void utilAddOrgPastEvent(String org_username, String event_title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
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

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }


    }

    /**This is a tool method used to delete a relationship from the database.
     * It deletes a relationship between an organization and a past event.
     *
     * @param org_username The username of the organization
     * @param event_title The title of the event
     */
    public void utilDeleteOrgPastEvent(String org_username, String event_title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "delete from past_events_for_org where org_username = '" + org_username + "' and event_title = '" + event_title + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0) {
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

    /**This is a tool method used to add a relationship to the database.
     * It adds a relationship between an unpublished event and an organization.
     *
     * @param org_username The username of the organization
     * @param event_title The title of the event
     */
    public void utilAddOrgUnpublishedEvent(String org_username, String event_title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
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

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }


    }

    /**This is a tool method used to delete a relationship from the database.
     * It deletes a relationship between an unpublished event and an organization.
     *
     * @param org_username The username of the organization
     * @param event_title The title of the event
     */
    public void utilDeleteOrgUnpublishedEvent(String org_username, String event_title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "delete from unpublished_events_for_org where org_username = '" + org_username + "' and event_title = '" + event_title + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0) {
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

    /**This is a tool method used to add a relationship to the database.
     * It adds a relationship between an upcoming event and an organization.
     *
     * @param org_username The username of the organization
     * @param event_title The title of the event
     */
    public void utilAddOrgUpcomingEvent(String org_username, String event_title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
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

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }


    }

    /**This is a tool method used to delete a relationship from the database.
     * It deletes a relationship between an upcoming event and an organization.
     *
     * @param org_username The username of the organization
     * @param event_title The title of the event
     */
    public void utilDeleteOrgUpcomingEvent(String org_username, String event_title) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "delete from upcoming_events_for_org where org_username = '" + org_username + "' and event_title = '" + event_title + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();

        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            JDBCUtils.close(stmt,conn);
        }

    }

    /**This is a tool method used to get all followers' name of the organization.
     *
     * @param org_username The username of the organization
     * @return All followers of the organization
     */
    public ArrayList<String> utilGetAllFollowers(String org_username) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "select par_username from follow_org_par where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            JDBCUtils.close_rs(rs);
            JDBCUtils.close(stmt,conn);
        }
        return l;



    }
    /**This is a tool method used to get all unpublished events of the organization.
     *
     * @param org_username The username of the organization
     * @return All unpublished events of the organization
     */
    public ArrayList<String> utilGetUnpublishedEvents(String org_username) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "select event_title from unpublished_events_for_org where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            JDBCUtils.close_rs(rs);
            JDBCUtils.close(stmt,conn);
        }
        return l;



    }

    /**This is a tool method used to get all past events of the organization.
     *
     * @param org_username The username of the organization
     * @return All past events of the organization
     */
    public ArrayList<String> utilGetPastEvents(String org_username) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "select event_title from past_events_for_org where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            JDBCUtils.close_rs(rs);
            JDBCUtils.close(stmt,conn);
        }
        return l;



    }

    /**This is a tool method used to get all upcoming events of the organization.
     *
     * @param org_username The username of the organization
     * @return All upcoming events of the organization
     */
    public ArrayList<String> utilGetUpcomingEvents(String org_username) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "select event_title from upcoming_events_for_org where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            JDBCUtils.close_rs(rs);
            JDBCUtils.close(stmt,conn);
        }
        return l;



    }

    /**This is a tool method used to get the password of the organization.
     *
     * @param org_username The username of the organization
     * @return The password of the organization
     */
    public String utilGetPassword(String org_username) throws SQLException, ClassNotFoundException {
        //Return the password of the entered organization user
        //Used for login password check
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String password;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select password from orgfile where username = '" + org_username + "';");
            rs.next();
            password = rs.getString("password");
            System.out.println(password);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            JDBCUtils.close_rs(rs);
            JDBCUtils.close(stmt,conn);
        }
        return password;
    }

    /**This is a tool method used to change the password of the organization.
     *
     * @param org_username The username of the organization
     * @param new_password The new password of the organization
     */
    public void utilPasswordUpdating(String org_username, String new_password) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "update orgfile set password = '" + new_password + "' where username = '" + org_username + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            JDBCUtils.close(stmt,conn);

        }
    }

    /**This is a tool method used to obtain all the organizations relevant to the input keyword.
     *
     * @param about_name The keyword that used for search for relevant organization
     * @return An ArrayList containing the name of all relevant organizations
     */
    public ArrayList<String> utilOrganizationSearch(String about_name) throws SQLException, ClassNotFoundException {
        //This is method is used for searching method of the website
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select username from orgfile where username like \"%" + about_name + "%\";");
            while (rs.next()) {
                l.add(rs.getString("username"));
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            JDBCUtils.close_rs(rs);
            JDBCUtils.close(stmt,conn);
        }
        return l;
    }

    /**This is a tool method returning whether the username exist.
     * If not found, returned false, which is the default value of the boolean stored in method.
     *
     * @param username The username that need to be used to check existence
     * @return Whether the username exists
     */
    public boolean utilCheckIfUsernameExist(String username) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean WhetherExist = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "select exists(select * from orgfile where username = '" + username + "');";
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            if (rs.getInt(1) == 1){
                WhetherExist = true;
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new SQLException();
        }finally {
            JDBCUtils.close_rs(rs);
            JDBCUtils.close(stmt,conn);
        }
        return WhetherExist;
    }



    /**this method is used to create an organization.
     * this method calls a tool method called createOrg.
     *
     * @param username The username of the organization
     * @param password The password of the organization
     */
    public void createOrg(String username, String password) throws SQLException, ClassNotFoundException {
        utilStoreOrg(username,password);
    }

    /**This method delete the organization from the database and removes all the relationship of the event created by the organization
     * and the relationship with all the followers
     * This method calls tool methods including
     * utilGetUnpublishedEvents, utilGetPastEvents, utilGetUpcomingEvents and utilGetAllFollowers.
     *
     * @param username The username of the organization
     */
    public void deleteOrg(String username) throws SQLException, ClassNotFoundException {
        ParFileUser temp_parFileUser = new ParFileUser();
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
            utilDeleteOrgUpcomingEvent(username, All_upcoming.get(i));
        }

        ArrayList<String> All_followers = utilGetAllFollowers(username);
        for (String all_follower : All_followers) {
            temp_parFileUser.utilDeleteParFollowOrg(all_follower, username);
        }

        utilDeleteOrg(username);
    }

    /**This is a method used to create event, it put an event into the database and build the relationship between
     * the organization and the event.
     *
     * @param org_username The username of the organization
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
    public void createAnEvent(String org_username, String title, int status, String description, String location, int year, int month, int day, int hour, int minute) throws SQLException, ClassNotFoundException {
        EventFileUser temp_eventFileUser = new EventFileUser();
        temp_eventFileUser.utilStoreEvent(title, description, location, year, month, day, hour, minute);
        if (status == 0){
            //Unpublished
            utilAddOrgUnpublishedEvent(org_username,title);
        }
        else if(status == 1){
            //Past
            utilAddOrgUpcomingEvent(org_username,title);
        }
        else{
            //Upcoming
            utilAddOrgPastEvent(org_username,title);

        }
    }

    /**This method delete the event and delete the relationship of the organization and the event
     * The deleteEvent method of the EventFileUser would automatically delete the relationship between the event
     * and the organization and the participants.
     *
     * @param title The title of the event
     */
    public void deleteAnEvent(String title) throws SQLException, ClassNotFoundException {
        EventFileUser temp_eventFileUser = new EventFileUser();
        temp_eventFileUser.deleteEvent(title);
    }

    /**This method returns the password of the organization.
     * This method calls a tool method.
     *
     * @param username The name of the organization
     * @return THe password of the organization
     */
    public String getPassword(String username) throws SQLException, ClassNotFoundException {
        return utilGetPassword(username);
    }

    /**This method is used to reset the password of the organization.
     * This method called a tool method called utilPasswordUpdating.
     *
     * @param username The name of the organization
     * @param new_password The new password of the organization
     */
    public void setPassword(String username, String new_password) throws SQLException, ClassNotFoundException {
        utilPasswordUpdating(username, new_password);
    }

    /**This is a method used to obtain all the organizations relevant to the input keyword.
     * This method called a tool method called utilOrganizationSearch.
     *
     * @param about_name The keyword that used for search for relevant organization
     * @return An ArrayList containing the name of all relevant organizations
     */
    public ArrayList<String> organizationSearch(String about_name) throws SQLException, ClassNotFoundException {
        return utilOrganizationSearch(about_name);
    }

    /**This is a method used to get all unpublished events.
     * This method called a tool method called utilGetUnpublishedEvents.
     *
     * @param username The username of the organization
     * @return The arraylist containing all unpublished events of the organization
     */
    public ArrayList<String> getUnpublishedEvents(String username) throws SQLException, ClassNotFoundException {
        return utilGetUnpublishedEvents(username);
    }

    /**This is a method used to get all past events.
     * This method called a tool method called utilGetPastEvents.
     *
     * @param username The username of the organization
     * @return The arraylist containing all past events of the organization
     */
    public ArrayList<String> getPastEvents(String username) throws SQLException, ClassNotFoundException {
        return utilGetPastEvents(username);
    }

    /**This is a method used to get all upcoming events.
     * This method called a tool method called utilGetUpcomingEvents.
     *
     * @param username The username of the organization
     * @return The arraylist containing all upcoming events of the organization
     */
    public ArrayList<String> getUpcomingEvents(String username) throws SQLException, ClassNotFoundException {
        return utilGetUpcomingEvents(username);
    }

    /**This is a method used to get all the followers of the organization.
     * This method used a tool method called utilGetAllFollowers.
     *
     * @param username The username of the organization
     * @return The arraylist containing all followers of the organization
     */
    public ArrayList<String> getFollowers(String username) throws SQLException, ClassNotFoundException {
        return utilGetAllFollowers(username);
    }

    /**This is a method returning whether the username exist.
     * This method calls a tool method called utilCheckIfUsernameExist.
     * If not found, returned false, which is the default value of the boolean stored in method.
     *
     * @param username The username that need to be used to check existence
     * @return Whether the username exists
     */
    public boolean checkIfUsernameExist(String username) throws SQLException, ClassNotFoundException {
        return utilCheckIfUsernameExist(username);
    }

    public void editAnEvent(String title, String description, String location, int year, int month, int day, int hour, int minute) throws SQLException, ClassNotFoundException {
        EventFileUser eventFileUser = new EventFileUser();
        eventFileUser.editEvent(title,description,location,year,month,day,hour,minute);

    }

    public Organization getOrganization(String username) throws SQLException, ClassNotFoundException {
        Organization org_to_return = new Organization(username, getPassword(username), getUnpublishedEvents(username),getPastEvents(username),getUpcomingEvents(username), getFollowers(username));
        return org_to_return;
    }

    public void saveOrganization(Organization org_to_save) throws SQLException, ClassNotFoundException {
        deleteOrg(org_to_save.getUsername());
        createOrg(org_to_save.getUsername(), org_to_save.getPassword());
        for (String unpublished_event: org_to_save.getUnpublished_events()){
            utilAddOrgUnpublishedEvent(org_to_save.getUsername(), unpublished_event);
        }
        for (String past_event: org_to_save.getPast_events()){
            utilAddOrgPastEvent(org_to_save.getUsername(), past_event);
        }
        for (String upcoming_events: org_to_save.getUpcoming_events()){
            utilAddOrgUpcomingEvent(org_to_save.getUsername(), upcoming_events);
        }
        for (String follower: org_to_save.getFollowers()){
            ParDsGateway parDsGateway = new ParFileUser();
            parDsGateway.followOrg(follower, org_to_save.getUsername());
        }
    }


}
