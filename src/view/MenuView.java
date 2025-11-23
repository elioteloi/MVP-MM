package view;


import products.Product;
import products.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame {
    private JPanel panel;

    public MenuView() {
        setTitle("Menu");
        setLayout(new FlowLayout());

        this.panel = new JPanel();
        this.panel.setLayout(new FlowLayout());
        this.panel.setPreferredSize(new Dimension(500, 800));
        add(this.panel);

        createButton("Add product", new ButtonRegisterProductHandler());
        createButton("Get a product", new ButtonGetProductHandler());
        createButton("Edit a product", new ButtonEditProductHandler());
        createButton("Delete a product", new ButtonDeleteProductHandler());
        createButton("Stock report", new ButtonStockReportHandler());
        createButton("Sale report", new ButtonSaleReportHandler());
        createButton("Exit", new ButtonExitHandler());

        setSize(new Dimension(500, 300));
        setPreferredSize(new Dimension(500, 800));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void createButton(String label, ActionListener listener)  {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setPreferredSize(new Dimension(300, 80));
        this.panel.add(button);
    }

    private static class ButtonRegisterProductHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new RegisterProductView();

        }
    }

    private static class ButtonGetProductHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new GetProductView();

        }
    }
    private static class ButtonEditProductHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new EditProductView();

        }
    }
    private static class ButtonDeleteProductHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new DeleteProductView();

        }
    }

    private static class ButtonStockReportHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new StockReport();

        }
    }

    private static class ButtonSaleReportHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new SaleReport();

        }
    }

    private static class ButtonExitHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
