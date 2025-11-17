package db;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public void create() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS userMM (" +
                    "id int AUTO_INCREMENT PRIMARY KEY , " +
                    "name VARCHAR(100), " +
                    "cellphone VARCHAR(20), " +
                    "category VARCHAR(100), " +
                    "cpf VARCHAR(20), " +
                    "cnpj VARCHAR(20)); ");
            System.out.println("Table user created sucessfully!");
        } catch (SQLException e) {
            System.err.println("Error creating the table: " + e.getMessage());
        }

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS productMM (" +
                    "id int AUTO_INCREMENT PRIMARY KEY , " +
                    "name VARCHAR(100), " +
                    "barcode VARCHAR(20), " +
                    "price VARCHAR(100), " +
                    "averageCost VARCHAR(20), " +
                    "stock VARCHAR(20)); ");
            System.out.println("Table product created sucessfully!");
        } catch (SQLException e) {
            System.err.println("Error creating the table: " + e.getMessage());
        }
    }
}