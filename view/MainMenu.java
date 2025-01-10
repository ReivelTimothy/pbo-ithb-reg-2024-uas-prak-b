package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenu {
    public static void main(String[] args) {
        new MainMenu();
    }
    public MainMenu(){
        JFrame frame = new JFrame();
        JPanel headerPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        JButton loginbutton = new JButton("LOGIN");
        JButton regisButton = new JButton("REGISTER");
        JButton addTransactionButton = new JButton("ADD TRANSACTION");
        JButton historyButton = new JButton("HISTORY");
        loginbutton.setSize(new Dimension(50,50));

        frame.setBounds(500,100,100,100);
        frame.setLayout(new GridLayout(2,1));
        JLabel label = new JLabel("SELAMAT DATANG");
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        headerPanel.add(label);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(new EmptyBorder(new Insets(100,100,100,100)));
        buttonPanel.add(loginbutton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,60)));
        buttonPanel.add(regisButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,60)));
        buttonPanel.add(addTransactionButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,60)));
        buttonPanel.add(historyButton);
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(headerPanel);
        frame.add(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
