package view;

import products.Product;
import products.ProductService;
import sales.Sale;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StockReport extends JFrame{

    public StockReport () {

        ProductService productService = new ProductService();

        List<Product> products = productService.listProduct();

        JFrame frame = new JFrame("Data Table");

        String[] columnNames = {"Id", "Name", "Bar code", "Price", "Average cost", "Stock"};


        Object[][] data = new Object[products.size()][6];

        try (PrintWriter writer = new PrintWriter(
                new FileWriter("stockReport.txt"))) {
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                writer.println("===============================");
                writer.println("id " + p.getId());
                writer.println("Name: " + p.getName());
                writer.println("bar code: " + p.getBarCode());
                writer.println("Price: " + p.getPrice());
                writer.println("Average cost: " + p.getAverageCost());
                writer.println("Stock: " + p.getStock());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            data[i][0] = p.getId();
            data[i][1] = p.getName();
            data[i][2] = p.getBarCode();
            data[i][3] = p.getPrice();
            data[i][4] = p.getAverageCost();
            data[i][5] = p.getStock();
        }


        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

  }
