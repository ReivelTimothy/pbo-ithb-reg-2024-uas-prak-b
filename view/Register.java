package view;

import java.awt.*;
import javax.swing.*;

public class Register {
    public static void main(String[] args) {
        new Register();
    }

    public Register() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("REGISTER");
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 30));
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.WHITE);

        JPanel nama = Templete.getInstance().createInputText("Nama : ");
        JPanel alamat = Templete.getInstance().createInputText("Alamat: ");
        JPanel telp = Templete.getInstance().createInputText("Nomor Telp: ");
        JPanel password = Templete.getInstance().createInputPassword("Password: ");

        formPanel.add(nama);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(alamat);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(telp);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(password);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(submitButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);

        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });

        frame.pack();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
