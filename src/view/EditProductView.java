package view;

import products.Product;
import products.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProductView extends JFrame {

    private JPanel panel;
    private JTextField tfId;
    private JTextField tfName;
    private JTextField tfBarCode;
    private JTextField tfPrice;
    private JTextField tfAverageCost;
    private JTextField tfStock;


    public EditProductView() {
        setTitle("Update product");
        setLayout(new FlowLayout());

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(500, 800));
        add(panel);

        createTextFieldId("Number of the id");
        createTextFieldName("Name of the item");
        createTextFieldBarCode("Number of the barcode");
        createTextFieldPrice("Number of the price");
        createTextFieldAverageCost("Number of the average cost");
        createTextFieldStock("Number of stock");

        createButton("Save", new ButtonSaveHandler());

        setSize(new Dimension(500, 800));
        setPreferredSize(new Dimension(500, 800));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void createlabel(String text) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(400, 40));
        this.panel.add(label);
    }

    private void createTextFieldId(String text) {
        createlabel(text);
        this.tfId = new JTextField();
        this.tfId.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.tfId);
    }

    private void createTextFieldName(String text) {
        createlabel(text);
        this.tfName = new JTextField();
        this.tfName.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.tfName);
    }

    private void createTextFieldBarCode(String text) {
        createlabel(text);
        this.tfBarCode = new JTextField();
        this.tfBarCode.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.tfBarCode);
    }

    private void createTextFieldPrice(String text) {
        createlabel(text);
        this.tfPrice = new JTextField();
        this.tfPrice.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.tfPrice);
    }
    private void createTextFieldAverageCost(String text) {
        createlabel(text);
        this.tfAverageCost = new JTextField();
        this.tfAverageCost.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.tfAverageCost);
    }
    private void createTextFieldStock(String text) {
        createlabel(text);
        this.tfStock = new JTextField();
        this.tfStock.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.tfStock);
    }

    private void createButton(String label, ActionListener listener)  {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setPreferredSize(new Dimension(300, 80));
        this.panel.add(button);
    }

    private void createItem() {
        Integer id = Integer.parseInt(this.tfId.getText());
        String name = this.tfName.getText();
        String barCode = this.tfBarCode.getText();
        Double price = Double.parseDouble(this.tfPrice.getText());
        Double averageCost = Double.parseDouble(this.tfAverageCost.getText());
        Integer stock = Integer.parseInt(this.tfStock.getText());

        ProductService productService = new ProductService();

        productService.editProduct(id, name, barCode, price, averageCost, stock);

        JOptionPane.showMessageDialog(null, "updated successfully: " + name);
    }

    private class ButtonSaveHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createItem();
        }
    }

}
