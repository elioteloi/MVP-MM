package view;

import products.Product;
import products.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetProductView extends JFrame {

    private JPanel panel;
    private JTextField tfId;

    public GetProductView() {
        setTitle("Get product");
        setLayout(new FlowLayout());

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(500, 1000));
        add(panel);

        createTextFieldId("Number of the id");

        createButton("search", new ButtonSaveHandler());

        setSize(new Dimension(500, 800));
        setPreferredSize(new Dimension(500, 1000));
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

    private void createButton(String label, ActionListener listener)  {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setPreferredSize(new Dimension(300, 80));
        this.panel.add(button);
    }

    private void createItem() {


        try {
            Integer id = Integer.parseInt(this.tfId.getText());

            JFrame frame = new JFrame("Data Table");

            String[] columnNames = {"Id", "Name", "Bar code", "Price", "Average cost", "Stock"};

            ProductService productService = new ProductService();

            Product p = productService.getProduct(id);

            Object[][] data = {
                    { p.getId(), p.getName(), p.getBarCode(), p.getPrice(), p.getAverageCost(), p.getStock() }
            };

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane);
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers for id.",
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);

        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private class ButtonSaveHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createItem();
        }
    }

}
