package view;

import products.Product;
import products.ProductService;

import javax.swing.*;
import java.util.List;

public class StockReport extends JFrame{

    public StockReport () {

        ProductService productService = new ProductService();

        List<Product> products = productService.listProduct();

        JFrame frame = new JFrame("Data Table");

        String[] columnNames = {"Id", "Name", "Bar code", "Price", "Average cost", "Stock"};


        Object[][] data = new Object[products.size()][6];

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
