package database;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtils {
    static final String databaseUrl = "jdbc:mysql://localhost:3306/db_nocare";
    static final String databaseUsername = "root";
    static final String databasePassword = "Anitahua0105";

    public static String getDatabaseUrl() {
        return databaseUrl;
    }

    public static String getDatabaseUsername() {
        return databaseUsername;
    }

    public static String getDatabasePassword() {
        return databasePassword;
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt, Connection conn) {
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close_rs(ResultSet rs) {
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void utilUpdateVoid(String sql) throws ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(stmt, conn);
        }
    }

    public static ArrayList<String> utilQueryArrayListString(String sql) throws ClassNotFoundException {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>(0);
        System.out.println("Start");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("HHH");
            while (rs.next()){
                l.add(rs.getString(1));
                System.out.println(l);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class");
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            System.out.println("SQL");
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close_rs(rs);
            JDBCUtils.close(stmt, conn);

        }
        return l;
    }


}
