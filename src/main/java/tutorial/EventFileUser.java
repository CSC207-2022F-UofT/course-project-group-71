package tutorial;

import java.sql.*;
import java.util.ArrayList;

public class EventFileUser {
    public static void main(String[] args) {
        EventFileUser b =new EventFileUser();
        b.UtilStoreEvent("D", 123, 3, "5", "A", "2312414",2004,5,1,3,4);
    }

    public void UtilStoreEvent(String title,
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
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            String sql = "insert into eventfile(title,status,event_type,description,location,image_path,year,month,day,hour,minute) values('" +
                    title + "'," + status + "," + event_type + ",'" + description + "','" + location + "','" + image_path + "'," + year + "," + month + "," + day + "," + hour + "," + minute + ");";
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
    public void UtilDeleteEvent(String title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
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

    public String UtilGetOrganizer(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String organizer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            stmt = conn.createStatement();
            try (ResultSet unpublished_organizer = stmt.executeQuery("select org_username from unpublished_events_for_org where event_title = '" + title + "';")){
                if (unpublished_organizer.next()){
                    organizer = unpublished_organizer.getString(1);
                    unpublished_organizer.close();
                };
            }
            try (ResultSet past_organizer = stmt.executeQuery("select org_username from past_events_for_org where event_title = '" + title + "';")){
                if (past_organizer.next()){
                    organizer = past_organizer.getString(1);
                    past_organizer.close();

                };
            }

            try (ResultSet upcoming_organizer = stmt.executeQuery("select org_username from past_events_for_org where event_title = '" + title + "';")){
                if (upcoming_organizer.next()){
                    organizer = upcoming_organizer.getString(1);
                    upcoming_organizer.close();
                }
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
        return organizer;




    }

    public ArrayList<String> UtilGetAllParticipants(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList l = new ArrayList<String>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select par_username from past_events_for_par where event_title = '" + title + "';");
            while (rs.next()){
                l.add(rs.getString(1));
            }
            rs = stmt.executeQuery("select par_username from upcoming_events_for_par where event_title = '" + title + "';");
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

















    public boolean CheckIfEventnameExist(String eventname){
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

    public void DeleteEvent(String event_title){
        //First break relationships of the event with the organizer
        //Then break relationships of the event with all the participants
        //Then delete the event itself
        OrgFileUser temp_orgfileuser = new OrgFileUser();
        ParFileUser temp_parfileuser = new ParFileUser();
        ArrayList<String> All_Participants = UtilGetAllParticipants(event_title);
        for (int i = 0; i < All_Participants.size(); i ++){
            temp_parfileuser.UtilDeleteParPastevent(All_Participants.get(i),event_title);
            temp_parfileuser.UtilDeleteParUpcomingevent(All_Participants.get(i),event_title);
        }

        String organizer = UtilGetOrganizer(event_title);
        temp_orgfileuser.UtilDeleteOrgPastEvent(organizer,event_title);
        temp_orgfileuser.UtilDeleteOrgUnpublishedEvent(organizer,event_title);
        temp_orgfileuser.UtilDeleteOrgUpcomingevent(organizer,event_title);

        UtilDeleteEvent(event_title);

    }
}
