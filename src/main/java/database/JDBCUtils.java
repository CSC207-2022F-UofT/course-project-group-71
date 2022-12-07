package database;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtils {
    static final String databaseUrl = "jdbc:mysql://localhost:3306/db_nocare";
    static final String databaseUsername = "root";
    static final String databasePassword = "1234";

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
            System.out.println(sql);
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                l.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close_rs(rs);
            JDBCUtils.close(stmt, conn);

        }
        return l;
    }


}
