package view;

import java.awt.*;
import javax.swing.*;
import controller.LoginSingleton;

public class Login {

    public Login() {
    }

    public void inputLogin() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.setLayout(new BorderLayout());

        // Panel logo di atas
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel logoLabel = new JLabel();
        String logoPath = "assets\\logo.png";
        ImageIcon logoIcon = new ImageIcon(logoPath);
        logoLabel.setIcon(logoIcon);
        logoPanel.add(logoLabel);

        // Panel form login
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel telpPanel = Templete.getInstance().createInputText("No Telp");
        JPanel passwordPanel = Templete.getInstance().createInputPassword("Password");

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        formPanel.add(telpPanel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(passwordPanel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        formPanel.add(buttonPanel);

        // Action listener untuk tombol
        submitButton.addActionListener(e -> {
            String telp = Templete.getInstance().getText(telpPanel);
            String pass = Templete.getInstance().getPassword(passwordPanel);

            LoginSingleton.checkLogin(telp, pass);

            if (LoginSingleton.getInstance().getId() != -1) {
                new MainMenu();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login gagal, silakan coba lagi.");
            }
        });

        cancelButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });

        frame.add(logoPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
