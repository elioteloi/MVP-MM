package products;
import clients.Client;
import clients.CorporateClient;
import clients.IndividualClient;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {

    private final Map<Integer, Product> products;
    private Connection conn;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        conn = DBConnection.getConnection();

        String insertSQL = "INSERT INTO productMM (name, barcode, price, averageCost, stock) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement stmt = conn.prepareStatement(insertSQL);) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getBarCode());
            stmt.setDouble(3, product.getPrice());
            stmt.setDouble(4, product.getAverageCost());
            stmt.setDouble(5, product.getStock());

            stmt.execute();
            System.out.println("Product successfully created");

        } catch (SQLException e) {
            System.err.println("Coundn't insert in database: " + e.getMessage());
        }

    }

    public String getProduct(int id) {
        conn = DBConnection.getConnection();

        String insertSQL = "SELECT * FROM productMM where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(insertSQL);) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return String.format(
                        "{\"id\": %d, \"name\": \"%s\", \"cellphone\": \"%s\" \"category\": \"%s\" \"cpf\": \"%s\" \"cnpj\": \"%s\"}",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            }
            System.out.println("Product " + id + " successfully selected");
            stmt.execute();
            System.out.println("Product" + id + "successfully edited");
        } catch (SQLException e) {
            System.err.println("Coundn't insert in database: " + e.getMessage());

        }


        return "{}";
    }


    public void editProduct(int id, String name, String barCode, double price, double averageCost, int stock) {
        conn = DBConnection.getConnection();

        String updateSQL = "UPDATE productMM SET name = ?, barcode = ?, price = ?, averageCost = ?, stock = ? WHERE id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(updateSQL)) {
            stmt.setString(1, name);
            stmt.setString(2, barCode);
            stmt.setDouble(3, price);
            stmt.setDouble(4, averageCost);
            stmt.setInt(5, stock);
            stmt.setInt(6, id);

            stmt.execute();

            System.out.println("Product " + id + " successfully edited");

        } catch (SQLException e) {
            System.err.println("Coundn't update in database: " + e.getMessage());
        }
    }

    public void deleteProduct(int id) {
        String deleteSQL = "DELETE FROM productMM where id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(deleteSQL)) {
            stmt.setInt(1, id);
            stmt.execute();

            System.out.println("Product " + id + " successfully deleted");

        } catch (SQLException e) {
            System.err.println("Coundn't delete products in database: " + e.getMessage());

        }
    }


    public void listProduct() {
        conn = DBConnection.getConnection();

        String insertSQL = "SELECT * FROM productMM";

        try(PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println( String.format(
                        "{\"id\": %d, \"name\": \"%s\", \"cellphone\": \"%s\" \"category\": \"%s\" \"cpf\": \"%s\" \"cnpj\": \"%s\"}",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
            System.out.println("All products successfully selected");

        } catch (SQLException e) {
            System.err.println("Coundn't select all the products in database: " + e.getMessage());
        }


    }


}
