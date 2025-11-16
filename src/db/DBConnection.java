package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/meubanco";
    private static final String user = "root";
    private static final String password = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successfully established");
        } catch (SQLException e) {
        System.out.println("Error of SQL syntax: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error with the conection: " + e.getMessage());
        }
        return conn;
    }

//    public static void close(Connection conn) {
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("Error of SQL syntax closing the sql connection: " + e.getMessage());
//        } catch (Exception e) {
//            System.out.println("Error clossing the connection: "+ e.getMessage());
//        }
//    }
}
