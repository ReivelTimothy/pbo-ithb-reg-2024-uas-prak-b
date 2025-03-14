package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class Templete {
    private static Templete templete;

    public static Templete getInstance() {

        if (templete == null) {
            templete = new Templete();
        }
        return templete;
    }

    public JPanel createInputText(String txt) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel title = new JLabel(txt);
        JTextField textFieldTitle = new JTextField();
        textFieldTitle.setPreferredSize(new Dimension(200, 30));
        panel.add(title, BorderLayout.WEST);
        panel.add(textFieldTitle, BorderLayout.EAST);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        return panel;

    }

    public JPanel createInputPassword(String txt) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel title = new JLabel(txt);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        panel.add(title, BorderLayout.WEST);
        panel.add(passwordField, BorderLayout.EAST);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        return panel;

    }

    public JPanel createInputComboBox(String txt, String[] options) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel title = new JLabel(txt);
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setPreferredSize(new Dimension(200, 30));
        panel.add(title, BorderLayout.WEST);
        panel.add(comboBox, BorderLayout.EAST);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        return panel;
    }

    public static JDatePickerImpl createJDatePicker() {
        JPanel container = new JPanel();
        JPanel subContainer = new JPanel();

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setPreferredSize(new Dimension(200, 30));

        subContainer.setLayout(new BorderLayout());

        container.add(subContainer);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        return datePicker;
    }

    public static JPanel createDateInput(JDatePickerImpl datePickerImpl, String labeltxt) {
        JPanel container = new JPanel();
        JPanel subContainer = new JPanel();

        subContainer.setLayout(new BorderLayout());
        subContainer.add(new JLabel(labeltxt), BorderLayout.WEST);
        subContainer.add(datePickerImpl, BorderLayout.EAST);

        container.add(subContainer);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        return container;

    }

    public JPanel createInputFileChooser(String labeltxt, JFrame frame) {

        JPanel panel = new JPanel();
        JPanel subContainer = new JPanel();
        JTextField path = new JTextField();
        path.setVisible(false);

        JButton openButton = new JButton("Open File");
        openButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih File Gambar");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                    "Image Files", "jpg", "Jpeg"));

            // Tampilkan JFileChooser
            int userSelection = fileChooser.showOpenDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                try {
                    File selectedFile = fileChooser.getSelectedFile();

                    String relativePath = "assets" + File.separator + selectedFile.getName();

                    path.setText(relativePath);
                    System.out.println(path.getText());
                    path.setVisible(false);

                    System.out.println("File dipilih: " + selectedFile.getPath());
                    System.out.println("Path relatif: " + relativePath);
                    JOptionPane.showMessageDialog(null, "file yang dipilih : " + relativePath);
                } catch (Exception ex) {
                    System.err.println("Kesalahan: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Tidak ada file yang dipilih.");
            }

        });

        subContainer.setLayout(new BorderLayout());
        subContainer.add(new JLabel(labeltxt), BorderLayout.WEST);
        subContainer.add(openButton, BorderLayout.EAST);

        panel.add(subContainer);
        panel.add(path);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        return panel;
    }

    public String getText(JPanel panel) {
        return ((JTextField) panel.getComponent(1)).getText();
    }

    public String getSelectedOption(JPanel panel) {
        JComboBox<?> comboBox = (JComboBox<?>) panel.getComponent(1);
        return comboBox.getSelectedItem().toString();
    }
    

    public Double getPrice(JPanel panel) {
        return Double.parseDouble(((JTextField) panel.getComponent(1)).getText());
    }

    public String getPassword(JPanel panel) {
        return String.valueOf(((JPasswordField) panel.getComponent(1)).getPassword());
    }

}
