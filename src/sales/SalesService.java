package sales;

import clients.Client;
import clients.ClientService;
import db.DBConnection;
import products.Product;
import products.ProductService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesService {
    public final Map<Integer, Sale> sales;
    private final ProductService productService;
    private final ClientService clientService;

    private Connection conn;

    public SalesService(ProductService productService, ClientService clientService) {
        this.sales = new HashMap<>();
        this.productService = productService;
        this.clientService = clientService;
    }

    public String addSale(Sale sale) {




        double total = 0.0;

        for (SalesItems item : sale.salesItems) {
            Product product = productService.getProduct(item.getId());

            conn = DBConnection.getConnection();
            String selectSQL = "SELECT id FROM userMM WHERE id = ? ";
            try (PreparedStatement stmt = conn.prepareStatement(selectSQL);) {
                stmt.setInt(1, sale.getId());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String selectSQLProduct = "SELECT stock FROM productMM WHERE id = ? ";

                    try (PreparedStatement stmtProd = conn.prepareStatement(selectSQLProduct)) {
                        stmtProd.setInt(1, item.getId());

                        ResultSet rsPro = stmtProd.executeQuery();

                        if (rsPro.next()) {

                            Integer stock = rsPro.getInt("stock");
                            if (stock < item.getQuantity()) {
                                throw new RuntimeException("Not enough stock for product: " + product.getName());
                            } else {
                                String insertSQL = "INSERT INTO saleMM (dateTime, clientId, name, quantity, price, discount, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?);";
//
                            try (PreparedStatement stmtIN = conn.prepareStatement(insertSQL);) {
                                stmtIN.setString(1, sale.getDataHora().toString());
                                stmtIN.setInt(2, sale.getClient().getId());
                                stmtIN.setString(3, item.getName());
                                stmtIN.setInt(4, item.getQuantity());
                                stmtIN.setDouble(5, item.getPrice());
                                stmtIN.setDouble(6, sale.getDiscount());
                                stmtIN.setDouble(7, sale.getTotalPrice());

                                stmtIN.execute();
                                System.out.println("Sale successfully created");
                            } catch (SQLException e) {
                                throw new RuntimeException("Database error while adding sale", e);
                            }
                            }

//
                        } else {
                            throw new IllegalArgumentException("There is no product with this id");
                        }
                    } catch (SQLException e){
                    throw new RuntimeException("Database error while adding product", e);

                    }

                } else {
                    throw new IllegalArgumentException("There is no user with this id");
                }

            } catch (SQLException e) {
                System.err.println("Coundn't select in database: " + e.getMessage());
            }


            // subtract the quantity with the stock
            int totalStockAfterSell = product.getStock() - item.getQuantity();
            // edit the new product with the new stock
            productService.editProduct(product.getId(),product.getName(), product.getBarCode(), product.getPrice(), product.getAverageCost(), totalStockAfterSell);

            // give the total of the sale
            total = total + item.getPrice() * item.getQuantity();

            System.out.println("Item: " + sale);
        }

        double discountAmount = total * sale.getDiscount();
        double finalPrice = total - discountAmount;

        // put total price to sale class
        sale.setTotalPrice(finalPrice);



        return String.format("Total price: $%.2f%nDiscount: %.0f%%%nFinal price: $%.2f",
                total, sale.getDiscount() * 100, finalPrice);
    }
    public List<Sale> listSale() {
        conn = DBConnection.getConnection();

        String insertSQL = "SELECT * FROM saleMM";
        Sale s = null;
        List<Sale> sales = new ArrayList<>();
        ArrayList<String> items = new ArrayList<>();
        try(PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                s = new Sale(
                        rs.getInt("id"),
                        rs.getString("dateTime"),
                        rs.getString("clientId"),
                        rs.getString("name"),
                        rs.getString("quantity"),
                        rs.getString("price"),
                        rs.getString("discount"),
                        rs.getString("totalPrice")
                );
                sales.add(s);
            }
            System.out.println("All products successfully selected");

        } catch (SQLException e) {
            System.err.println("Coundn't select all the products in database: " + e.getMessage());
        }

        return sales;
    }

}
