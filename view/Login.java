package view;

import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
    

public class Login {
    private JFrame frame;
    public static void main(String[] args) {
        new Login().inputLogin();
    }

    public Login() {
        
    }

    public void inputLogin() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("LOGIN");
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
        masterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel email = Templete.getInstance().createInputText("Email ");
        JPanel Password = Templete.getInstance().createInputPassword("Password");

        masterPanel.add(email);
        masterPanel.add(Password);
        masterPanel.add(new JButton("Submit"));

        frame.add(masterPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}