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


        String selectSQL = "SELECT name FROM productMM WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectSQL);) {
            stmt.setString(1, product.getName());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                throw new IllegalArgumentException("There is already a product with this name");
            } else {
                String insertSQL = "INSERT INTO productMM (name, barcode, price, averageCost, stock) VALUES (?, ?, ?, ?, ?);";
                try (PreparedStatement stmtIN = conn.prepareStatement(insertSQL);) {
                    stmtIN.setString(1, product.getName());
                    stmtIN.setString(2, product.getBarCode());
                    stmtIN.setDouble(3, product.getPrice());
                    stmtIN.setDouble(4, product.getAverageCost());
                    stmtIN.setDouble(5, product.getStock());

                    stmtIN.execute();
                    System.out.println("Product successfully created");

                } catch (SQLException e) {
                    throw new RuntimeException("Database error while adding product", e);
                }


            }

        } catch (SQLException e) {
            System.err.println("Coundn't select in database: " + e.getMessage());
        }

    }

    public Product getProduct(int id) {
        conn = DBConnection.getConnection();

        String insertSQL = "SELECT * FROM productMM where id = ?";
        Product p = null;
        try (PreparedStatement stmt = conn.prepareStatement(insertSQL);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("barcode"),
                        rs.getDouble("price"),
                        rs.getDouble("averageCost"),
                        rs.getInt("stock")
                );

            }
            System.out.println("Product " + id + " successfully selected");
            stmt.execute();
        } catch (SQLException e) {
            System.err.println("Coundn't insert in database: " + e.getMessage());

        }


        return p;
    }


    public void editProduct(int id, String name, String barCode, double price, double averageCost, int stock) {
        conn = DBConnection.getConnection();

        String selectSQL = "SELECT id FROM productMM WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(selectSQL)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                String updateSQL = "UPDATE productMM SET name = ?, barcode = ?, price = ?, averageCost = ?, stock = ? WHERE id = ?";

                try(PreparedStatement stmtIN = conn.prepareStatement(updateSQL)) {
                    stmtIN.setString(1, name);
                    stmtIN.setString(2, barCode);
                    stmtIN.setDouble(3, price);
                    stmtIN.setDouble(4, averageCost);
                    stmtIN.setInt(5, stock);
                    stmtIN.setInt(6, id);

                    stmtIN.execute();

                    System.out.println("Product " + id + " successfully edited");

                } catch (SQLException e) {
                    System.err.println("Coundn't update in database: " + e.getMessage());

                }
            }  else {
                System.out.println("there is no product with this id: " + id);
            }


        } catch (SQLException e) {
            System.err.println("Coundn't select in database: " + e.getMessage());
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


    public List<Product> listProduct() {
        conn = DBConnection.getConnection();

        String insertSQL = "SELECT * FROM productMM";
        Product p = null;
        List<Product> products = new ArrayList<>();
        try(PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("barcode"),
                        rs.getDouble("price"),
                        rs.getDouble("averageCost"),
                        rs.getInt("stock")
                );
                products.add(p);
            }
            System.out.println("All products successfully selected");

        } catch (SQLException e) {
            System.err.println("Coundn't select all the products in database: " + e.getMessage());
        }

        return products;
    }


}
