package tutorial;

import java.sql.*;

public class OrgFileUser {
    public static void main(String[] args) {
//        System.out.println(GetPassword("A"));
//        StoreOrgIntoList("B", "eoejrt");
        DeleteOrgFromList("B");
    }
    public static void StoreOrgIntoList(String username, String password){
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
    public static void DeleteOrgFromList(String username){
        //Now when we delete the organization account, the event created by the organizer won't be deleted, but it will not have an organizer
        //Not finished, the plan changed, so the event will be deleted so is the connection between the events and participatns

        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            stmt = conn.createStatement();
            int UpcomingConnect = stmt.executeUpdate("delete from upcoming_events_for_org where org_username = \"" + username + "\";");
            int PastConnect = stmt.executeUpdate("delete from past_event_for_org where org_username = \"" + username + "\";");
            int UnpulishedConnect = stmt.executeUpdate("delete from unpublished_event_for_org where org_username = \"" + username + "\";");
            int FollowConnect = stmt.executeUpdate("delete from follow_org_par where org_username = \"" + username + "\";")
            int count = stmt.executeUpdate("delete from orgfile where username = '" + username + "';");
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

    public static int GetPassword(String username) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        int password = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "select password from orgfile where username = \"" + username + "\";";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            password = rs.getInt("password");
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
}
