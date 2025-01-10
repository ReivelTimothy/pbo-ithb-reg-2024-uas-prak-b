package view;

import java.awt.*;
import java.io.File;
import javax.swing.*;

import controller.LoginSingleton;

public class Login {
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().inputLogin());
    }

    public Login() {
    }

    public void inputLogin() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.setLayout(new BorderLayout());

        // Panel logo di atas
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel logoLabel = new JLabel();
        String logoPath = "UasPrakPbo\\assets\\logo.png";
        File logoFile = new File(logoPath);
        File logoFile2 = new File(logoFile.getAbsolutePath());
        if (!logoFile2.exists()) {
            System.out.println("File tidak ditemukan: " + logoFile.getAbsolutePath());
        } else {
            ImageIcon logoIcon = new ImageIcon(logoPath);
            if (logoIcon.getIconWidth() == -1) {
                System.out.println("File ditemukan tetapi tidak dapat dimuat: " + logoFile.getAbsolutePath());
            } else {
                logoLabel.setIcon(logoIcon);
            }
        }

        logoPanel.add(logoLabel);

        // Panel form login
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel telpPanel = Templete.getInstance().createInputText("No Telp");
        JPanel passwordPanel = Templete.getInstance().createInputPassword("Password");

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        formPanel.add(telpPanel);
        formPanel.add(passwordPanel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(submitButton);

        submitButton.addActionListener(e -> {
            String telp = Templete.getInstance().getText(telpPanel);
            String pass = Templete.getInstance().getPassword(passwordPanel);
            System.out.println(telp);
            System.out.println(pass);
            
            LoginSingleton.checkLogin(telp, pass);
            
            if (LoginSingleton.getInstance().getId() != -1) {
                new MainMenu();   
                frame.dispose(); 
            } else {
                JOptionPane.showMessageDialog(null, "Login gagal, silakan coba lagi.");
            }
        });

        frame.add(logoPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}