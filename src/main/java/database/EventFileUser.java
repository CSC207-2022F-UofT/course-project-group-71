package database;

import java.sql.*;
import java.util.ArrayList;

public class EventFileUser implements EventDsGateway{
    public static void main(String[] args) {
        EventFileUser b =new EventFileUser();
//        b.utilStoreEvent("E", 123, 3, "5", "A", "2312414",2004,5,1,3,4);
        System.out.println(b.checkIfEventNameExist("A"));

    }

    public void utilStoreEvent(String title,
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
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
    public void utilDeleteEvent(String title){
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
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

    public String utilGetOrganization(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String organizer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
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


    public ArrayList<String> utilGetAllPastEventParticipant(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList l = new ArrayList<String>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select par_username from past_events_for_par where event_title = '" + title + "';");
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
    public ArrayList<String> utilGetAllUpcomingEventParticipant(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList l = new ArrayList<String>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
            stmt = conn.createStatement();
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





    public int getStatus(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        int status = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
            String sql = "select status from eventfile where title = '" + title + "';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            status = rs.getInt("status");
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
        return status;

    }

    public int getType(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        int type = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
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

    public String getDescription(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String description = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
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

    public String getLocation(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String location = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
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

    public String getImagePath(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String image_path = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
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

    public ArrayList<Integer> getTime(String title){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<Integer> l = new ArrayList<Integer>(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
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

    public ArrayList<String> getParticipants(String title){
        ArrayList<String> l1 = utilGetAllPastEventParticipant(title);
        ArrayList<String> l2 = utilGetAllUpcomingEventParticipant(title);
        ArrayList<String> l = new ArrayList<String>(0);
        l.addAll(l1);
        l.addAll(l2);
        return l;
    }

    public String getOrganization(String title){
        return utilGetOrganization(title);
    }





















    public boolean checkIfEventNameExist(String eventname){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean WhetherExist = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "vvks1309");
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

    public void deleteEvent(String event_title){
        //First break relationships of the event with the organizer
        //Then break relationships of the event with all the participants
        //Then delete the event itself
        OrgFileUser temp_orgfileuser = new OrgFileUser();
        ParFileUser temp_parfileuser = new ParFileUser();
        ArrayList<String> All_past_participants = utilGetAllPastEventParticipant(event_title);
        for (int i = 0; i < All_past_participants.size(); i ++){
            temp_parfileuser.utilDeleteParPastevent(All_past_participants.get(i),event_title);
        }
        ArrayList<String> All_upcoming_participants = utilGetAllUpcomingEventParticipant(event_title);
        for (int i = 0; i < All_upcoming_participants.size(); i ++){
            temp_parfileuser.utilDeleteParUpcomingevent(All_upcoming_participants.get(i),event_title);
        }


        String organizer = utilGetOrganization(event_title);
        temp_orgfileuser.utilDeleteOrgPastEvent(organizer,event_title);
        temp_orgfileuser.utilDeleteOrgUnpublishedEvent(organizer,event_title);
        temp_orgfileuser.utilDeleteOrgUpcomingevent(organizer,event_title);

        utilDeleteEvent(event_title);

    }
}
