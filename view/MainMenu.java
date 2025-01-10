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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginSingleton;

public class MainMenu {
    public static void main(String[] args) {
        new MainMenu();
    }

    public MainMenu() {
        JFrame frame = new JFrame();
        JPanel headerPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        // Membuat tombol
        JButton loginButton = new JButton("LOGIN");
        JButton regisButton = new JButton("REGISTER");
        JButton addDetailButton = new JButton("ADD DETAIL TRANSACTION");
        JButton addTransactionButton = new JButton("ADD TRANSACTION");
        JButton historyButton = new JButton("HISTORY");
        JButton logoutButton = new JButton("LOGOUT");

        // Mengatur ukuran tombol dan font
        Dimension buttonSize = new Dimension(250, 40);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        JButton[] buttons = {loginButton, regisButton, addDetailButton, addTransactionButton, historyButton, logoutButton};
        for (JButton button : buttons) {
            button.setPreferredSize(buttonSize);
            button.setFont(buttonFont);
            button.setAlignmentX(JButton.CENTER_ALIGNMENT);
            button.setMargin(new Insets(5, 15, 5, 15));
        }

        // Mengatur frame dan layout
        frame.setBounds(500, 100, 600, 400);
        frame.setLayout(new GridLayout(2, 1));
        JLabel label = new JLabel("SELAMAT DATANG");
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        headerPanel.add(label);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Menambahkan tombol ke panel dengan spasi antar tombol
        buttonPanel.add(loginButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(regisButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(addTransactionButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(historyButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(logoutButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(headerPanel);
        frame.add(buttonPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Menentukan visibilitas tombol berdasarkan login status
        if (LoginSingleton.getInstance().getId() == -1) {
            loginButton.setVisible(true);
            regisButton.setVisible(true);
            addTransactionButton.setVisible(false);
            historyButton.setVisible(false);
            logoutButton.setVisible(false);
        } else {
            loginButton.setVisible(false);
            regisButton.setVisible(false);
            addTransactionButton.setVisible(true);
            historyButton.setVisible(true);
            logoutButton.setVisible(true);
        }

        // Action untuk tombol
        loginButton.addActionListener(e -> {
            new Login().inputLogin();
            frame.dispose();
        });

        regisButton.addActionListener(e -> {
            new Register();
            frame.dispose();
        });

        addTransactionButton.addActionListener(e -> {
            new AddDeliveryTransaction();
            frame.dispose();
        });

        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Terimakasih " + LoginSingleton.getInstance().getCustomer().getName() + ", Sampai Berjumpa lagi!");
            LoginSingleton.getInstance().setCustomer(null);
            LoginSingleton.setInstance(null);
            frame.dispose();
            new MainMenu();
        });
    }
}
