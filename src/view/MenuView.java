package view;


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
        this.panel.setPreferredSize(new Dimension(500, 200));
        add(this.panel);

        createButton("Register", new ButtonRegisterHandler());

        createButton("Exit", new ButtonExitHandler());

        setSize(new Dimension(500, 300));
        setPreferredSize(new Dimension(500, 200));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void createButton(String label, ActionListener listener)  {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setPreferredSize(new Dimension(300, 80));
        this.panel.add(button);
    }

    private static class ButtonRegisterHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new RegisterProductView();

        }
    }
    private static class ButtonExitHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
