package database;

import java.sql.*;

import static Main.*;

public class JDBCUtils {
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
