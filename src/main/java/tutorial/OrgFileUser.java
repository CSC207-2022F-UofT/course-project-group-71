package tutorial;

import java.sql.*;
import java.util.ArrayList;

public class OrgFileUser implements OrgGateway{
    public static void main(String[] args) {
//        OrgFileUser a = new OrgFileUser();
//        a.CreateAnEvent("D",123,3,5,"A","23515",2004,5,9,71,23);
    }
    public void utilStoreOrg(String username, String password){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public void utilDeleteOrg(String username){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public void utilAddOrgPastEvent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public void utilDeleteOrgPastEvent(String org_username, String event_title) {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "delete from follow_org_par where org_username = '" + org_username + "' and event_title = '" + event_title + "';";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(sql);
            if (count > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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

    public void utilAddOrgUnpublishedEvent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public void utilDeleteOrgUnpublishedEvent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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
            e.printStackTrace();
        } catch (SQLException e) {
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

    public void utilAddOrgUpcomingEvent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public void utilDeleteOrgUpcomingevent(String org_username, String event_title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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
            e.printStackTrace();
        } catch (SQLException e) {
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

    public ArrayList<String> utilGetAllFollowers(String org_username){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList l = new ArrayList<String>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "select par_username from follow_org_par where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    public ArrayList<String> utilGetUnpublishedEvents(String org_username){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList l = new ArrayList<String>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "select event_title from unpublished_events_for_org where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    public ArrayList<String> utilGetPastEvents(String org_username){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList l = new ArrayList<String>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "select event_title from past_events_for_org where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    public ArrayList<String> utilGetUpcomingEvents(String org_username){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList l = new ArrayList<String>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "select event_title from upcoming_events_for_org where org_username = '" + org_username + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
//            rs.next();
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public void utilPasswordUpdating(String org_username, String new_password){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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
            e.printStackTrace();
        } catch (SQLException e) {
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
















    public String getPassword(String username) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String password = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "select password from orgfile where username = \"" + username + "\";";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
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

    public void setPassword(String username, String new_password){
        utilPasswordUpdating(username, new_password);
    }


    public ArrayList<String> getUnpublishedEvents(String username){
        return utilGetUnpublishedEvents(username);
    }

    public ArrayList<String> getPastEvent(String username){
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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
        for (int i=0; i<All_Unpublished.size();i++){
            utilDeleteOrgUnpublishedEvent(username, All_Unpublished.get(i));
        }
        ArrayList<String> All_Past = utilGetPastEvents(username);
        for (int i=0; i<All_Past.size();i++){
            utilDeleteOrgPastEvent(username, All_Past.get(i));
        }
        ArrayList<String> All_upcoming = utilGetUpcomingEvents(username);
        for (int i=0; i<All_Past.size();i++){
            utilDeleteOrgUpcomingevent(username, All_upcoming.get(i));
        }

        ArrayList<String> All_followers = utilGetAllFollowers(username);
        for (int i=0; i<All_followers.size();i++){
            temp_parfileuser.utilDeleteParFollowOrg(All_followers.get(i), username);
        }

        utilDeleteOrg(username);
    }

}
