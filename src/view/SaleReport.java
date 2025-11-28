package view;

import clients.ClientService;
import products.Product;
import products.ProductService;
import sales.Sale;
import sales.SalesService;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaleReport extends JFrame{

    public SaleReport () {

        ProductService productService = new ProductService();
        ClientService clientService = new ClientService();

        SalesService salesService = new SalesService(productService, clientService);

        List<Sale> sales = salesService.listSale();

        JFrame frame = new JFrame("Data Table");

        String[] columnNames = {"Id", "dateTime", "clientId", "name", "quantity", "price", "discount", "total price"};


        Object[][] data = new Object[sales.size()][8];

        try (PrintWriter writer = new PrintWriter(
                new FileWriter("salesReport.txt"))) {
            for (int i = 0; i < sales.size(); i++) {
                Sale s = sales.get(i);
                writer.println("===============================");
                writer.println("id " + s.getId());
                writer.println("Date-Time: " + s.getDataHora());
                writer.println("Id client: " + s.getClient().getId());
                writer.println("Name: " + s.getName());
                writer.println("Quantity: " + s.getQuantity());
                writer.println("Price: " + s.getPrice());
                writer.println("Discount: " + s.getDiscount());
                writer.println("Total price: " + s.getTotalPrice());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < sales.size(); i++) {
            Sale s = sales.get(i);
            data[i][0] = s.getId();
            data[i][1] = s.getDataHora();
            data[i][2] = s.getClient().getId();
            data[i][3] = s.getName();
            data[i][4] = s.getQuantity();
            data[i][5] = s.getPrice();
            data[i][6] = s.getDiscount();
            data[i][7] = s.getTotalPrice();


        }


        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
