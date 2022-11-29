package database;

import java.sql.*;

public class JDBCUtils {
    static final String databaseUrl = "jdbc:mysql://localhost:3306/db2";
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

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(getDatabaseUrl(), getDatabaseUsername(), getDatabasePassword());
    }

    public static void close(Statement stmt, Connection conn) throws SQLException {
        if (stmt != null){
            stmt.close();
        }
        if (conn != null){
            conn.close();
        }
    }

    public static void close_rs(ResultSet rs) throws SQLException {
        if (rs != null){
            rs.close();
        }
    }


}
