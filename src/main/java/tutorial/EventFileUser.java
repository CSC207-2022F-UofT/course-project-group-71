package tutorial;

import java.sql.*;

public class EventFileUser {
    public static void main(String[] args) {
//        StoreEventIntoList("a", 123, 3, 5, "A", "2312414", "12451d");
        DeleteEventFromList("testA");
    }

    public static void StoreEventIntoList(String title,
                                          int organization,
                                          int status,
                                          int event_type,
                                          String description,
                                          String location,
                                          String image_path){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "insert into eventfile(title, organization_id, status, event_type, description, location, image_path) values(\"" + title + "\"," + organization + "," + status + "," + event_type +
                    ",\"" + description + "\",\"" + location + "\",\"" + image_path + "\");";
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
    public static void DeleteEventFromList(String title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            stmt = conn.createStatement();
            int Parconnect = stmt.executeUpdate("delete from upcoming_events_for_par where event_title = \"" + title + "\";");
            int Orgconnect = stmt.executeUpdate("delete from upcoming_events_for_org where event_title = \"" + title + "\";");
            int count = stmt.executeUpdate("delete from eventfile where title = \"" + title + "\";");
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
    public static boolean CheckIfEventnameExist(String eventname){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean WhetherExist = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "select exists(select * from eventfile where title = '" + eventname + "');";
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
}
