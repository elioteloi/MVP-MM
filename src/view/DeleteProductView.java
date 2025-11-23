package view;

import products.Product;
import products.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProductView extends JFrame {

    private JPanel panel;
    private JTextField tfId;




    public DeleteProductView() {
        setTitle("Delete product");
        setLayout(new FlowLayout());

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(500, 800));
        add(panel);

        createTextFieldId("Id of the item");

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


    private void createButton(String label, ActionListener listener)  {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setPreferredSize(new Dimension(300, 80));
        this.panel.add(button);
    }

    private void createItem() {
        Integer id = Integer.parseInt(this.tfId.getText());


        ProductService productService = new ProductService();

//
        productService.deleteProduct(id);
        JOptionPane.showMessageDialog(null, "deleted successfully: " + id);
    }

    private class ButtonSaveHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createItem();
        }
    }

}
